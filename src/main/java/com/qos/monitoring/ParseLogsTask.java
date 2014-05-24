package com.qos.monitoring;

import org.quartz.Trigger;

public class ParseLogsTask {
	public void getLog(Trigger trigger) throws InterruptedException {
		System.out.println(trigger.getName() + "# Next Fire Time: " + trigger.getNextFireTime());
                System.out.println("yo");
                Thread.sleep(1000l);
                System.out.println("yo");
	}
}
