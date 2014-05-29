package com.qos.monitoring;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ParseLogsJob extends QuartzJobBean {
	private ParseLogsTask parseLogsTask;

	public void setParseLogsTask(ParseLogsTask parseLogsTask) {
		this.parseLogsTask = parseLogsTask;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

            try {
                parseLogsTask.getLog(context.getTrigger());
            } catch (Exception ex) {
                Logger.getLogger(ParseLogsJob.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}
