package com.qos.monitoring;

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

		parseLogsTask.getLog(context.getTrigger());
	}

}
