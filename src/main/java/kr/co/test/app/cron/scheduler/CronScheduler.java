package kr.co.test.app.cron.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import kr.co.test.app.cron.job.CronJob;

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
public class CronScheduler {
	
	@PostConstruct
	public void start() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		JobDetail jobDetail = JobBuilder.newJob(CronJob.class).withIdentity("cronJob")
				.usingJobData(this.setDataMap()).storeDurably().build();
		
		/*
		 * Cron 표현식 참고
		 *   - https://jaeuk2274.tistory.com/48
		 *   - 유닉스/리눅스의 cron 표현식에 ? 한자리 추가
		 */
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/10 * * * * ?");
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger")
				.withSchedule(scheduleBuilder).build();
		
		scheduler.scheduleJob(jobDetail, trigger);
	}
	
	private JobDataMap setDataMap() {
		JobDataMap dataMap = new JobDataMap();
		
		Map<String, Object> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map);
		
		map = new HashMap<>();
		map.put("c", 3);
		map.put("d", 4);
		list.add(map);
		
		dataMap.put("abc", 1234);
		dataMap.put("aaa", map);
		dataMap.put("bbb", list);
		
		return dataMap;
	}
	
}
