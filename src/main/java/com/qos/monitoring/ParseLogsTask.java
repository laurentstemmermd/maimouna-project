package com.qos.monitoring;

import au.com.bytecode.opencsv.CSVReader;
import com.qos.models.Log;
import com.qos.models.LogStatus;
import com.qos.models.Site;
import com.qos.services.daos.LogDao;
import com.qos.services.daos.SiteDao;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
import org.quartz.Trigger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class ParseLogsTask {

    private static final String SUPPORT_EMAIL = "xxx@xxx.xxx";

    @Resource
    private SiteDao siteDao;

    @Resource
    private LogDao logDao;

    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public void getLog(Trigger trigger) throws InterruptedException, FileNotFoundException, IOException {
        System.out.println(trigger.getName() + "# Next Fire Time: " + trigger.getNextFireTime());
        List<Site> lists = siteDao.getAllSites();
        System.out.println("Il y a " + lists.size() + " sites");
        for (Site site : lists) {
            String localLogPath = null;

            try {
                localLogPath = retrieveLog(site);
            } catch (Exception _e) {
            }
            if (localLogPath != null) {
                String fp = getFileFootPrint(localLogPath);
                System.out.println("getLogFootprint for " + site.getName());
                String siteFootPrint = siteDao.getLogFootprint(site.getId());
                if (siteFootPrint != null && siteFootPrint.equals(fp)) {
                    System.out.println("File hasn't change !");
                } else {
                    parseLogs(site, localLogPath);
                    siteDao.setLogFootprint(site.getId(), fp);
                }
            }
        }
    }

    private void sendEmail(String email, Log log) {
        // Create a thread safe "copy" of the template message and customize it
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(email);
        msg.setText(
                "Dear " + email
                        + ", and error has been discovered. Here is the log : "
                        + log);
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }

    private String getFileFootPrint(String localLogPath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(localLogPath));
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
        fis.close();
        return md5;
    }

    private String retrieveLog(Site site) throws IOException {
        switch (site.getConnectionType()) {
            case FTP:
                System.out.println(site.getName() + " tranfert de type " + site.getConnectionType() + ", parsing...");
                return retrieveLogWithFTP(site);
            default:
                throw new UnsupportedOperationException("Type " + site.getConnectionType() + " not supported yet.");
        }
    }

    private void parseLogs(Site site, String localLogPath) throws FileNotFoundException, IOException {
        switch (site.getLogType()) {
            case CSV:
                System.out.println(site.getName() + " de type " + site.getLogType() + ", parsing...");

                parseCSVLogs(site, localLogPath);
                break;
            default:
                throw new UnsupportedOperationException("Type " + site.getLogType() + " not supported yet.");
        }
    }

    private void parseCSVLogs(Site site, String localLogPath) throws FileNotFoundException, IOException {
        CSVReader reader = new CSVReader(new FileReader(localLogPath), ';');
        String[] nextLine;
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            DateTime dt = formatter.parseDateTime(nextLine[4]);

            Log log = new Log(nextLine[0], dt, LogStatus.valueOf(nextLine[1]), nextLine[2], nextLine[3]);

            if(!logDao.exists(log, site.getName())) {
                if(log.getStatus() == LogStatus.KO) {
                    sendEmail(SUPPORT_EMAIL, log);
                }
                logDao.insert(log, site.getName());
            }
        }
        reader.close();
    }

    // https://help.ubuntu.com/10.04/serverguide/ftp-server.html
    private String retrieveLogWithFTP(Site site) throws IOException {
        String remotePath = site.getLogPath();
        String localPath = FileUtils.getTempDirectoryPath() + File.separator + site.getName() + "." + site.getLogType().toString().toLowerCase();
        System.out.println("Let's copy " + remotePath + " to " + localPath);

        String server = site.getHost();
        int port = 21;
        String user = site.getUserName();
        String pass = site.getPassword();

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File downloadFile1 = new File(localPath);
            OutputStream local = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remotePath, local);
            local.close();

            if (success) {
                System.out.println("File has been downloaded successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return localPath;
    }

    private void parseLog(String logFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
