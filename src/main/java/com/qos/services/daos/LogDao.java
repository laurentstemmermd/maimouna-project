/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos.services.daos;

import com.qos.models.Log;
import com.qos.models.LogStatus;
import com.qos.models.Site;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Date: 8/30/13
 * Time: 11:28 AM
 */
@Service
public class LogDao {

    @Resource
    private DataSource dataSource;
    @Resource
    private SiteDao siteDao;

    public final List<Log> getAllLogs(String siteName) {
        Site site = siteDao.getSite(siteName);
        if(site == null) {
            return null;
        }

        final String sql = "SELECT SERVICE, STATUS, ATTEMPT, STATUS_INFO, EVENT_DATE FROM LOGS WHERE SITE_ID = ?";
        List<Log> result = new ArrayList<Log>();
        try {
            Connection c = dataSource.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, site.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())  {
                result.add(new Log(
                        rs.getString("SERVICE"), 
                        new DateTime(rs.getTimestamp("EVENT_DATE").getTime()), 
                        LogStatus.valueOf(rs.getString("STATUS")), 
                        rs.getString("ATTEMPT"), 
                        rs.getString("STATUS_INFO")
                    ));
            }
            rs.close();
            ps.close();
            c.close();
            return result;
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return null;
    }

    public final boolean insert(Log log, String siteName) {

        Site site = siteDao.getSite(siteName);
        if(site == null) {
            return false;
        }

        final String sql = "INSERT INTO logs(site_id, service, status, attempt, status_info, event_date) "
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            Connection c = dataSource.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, site.getId());
            ps.setString(2, log.getService());
            ps.setString(3, log.getStatus().name());
            ps.setString(4, log.getAttempt());
            ps.setString(5, log.getStatusInfo());
            ps.setTimestamp(6, new Timestamp(log.getEventDate().toDate().getTime()));

            int nb = ps.executeUpdate();
            ps.close();

                return nb == 1;
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return false;
    }
}
