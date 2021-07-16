package kr.co.test.app.simple.scheduler;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import kr.co.test.app.simple.job.SimpleJob;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2021. 7. 16. kdk	최초작성
 * </pre>
 * 
 *
 * @author kdk
 */
@Component
public class SimpleScheduler {

	@PostConstruct
	public void start() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("simpleJob")
				.usingJobData("name", "World").storeDurably().build();
		
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(5).repeatForever();
		
		// withIntervalInMilliseconds, withIntervalInSeconds, withIntervalInMinutes, withIntervalInHours
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger")
				.withSchedule(scheduleBuilder).build();
		
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
}
