package com.example.demo;

import java.util.Calendar;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class SchedulerConfig {

	@Bean
	public JobDetail testJobDetail() {
		return JobBuilder.newJob(Job.class).withIdentity("job")
				.storeDurably().build();
	}
	
	@Bean
	public Trigger testJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(10).repeatForever();
		
		return TriggerBuilder.newTrigger().forJob(testJobDetail())
				.withIdentity("trigger").withSchedule(scheduleBuilder).build();
	}
	
	
	@Bean
	@Scheduled(cron = "0 0 0 L * ?")
	public void trigerMjesec() {
		

		Calendar trigger = Calendar.getInstance();
		 if (trigger.get(Calendar.DATE) == trigger.getMaximum((Calendar.DATE))) {
			  System.out.println("Trigger");
		 }
		
		
	}
	
	
	
	
	
	
}

