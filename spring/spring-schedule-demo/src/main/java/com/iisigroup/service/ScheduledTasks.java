package com.iisigroup.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(initialDelay = 1000, fixedRate = 2000)
	public void reportByFixed() {
		System.out.println("I'm fixed rate. The time is now " + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0/2 * * * * *")
	public void reportByCron() {
		System.out.println("I'm cron expression. The time is now " + dateFormat.format(new Date()));
	}
}