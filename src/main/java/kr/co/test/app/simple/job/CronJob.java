package kr.co.test.app.simple.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import kr.co.test.app.common.LogDeclare;

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
public class CronJob extends LogDeclare implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		
		logger.debug("I am CronJob, JobDataMap_1 : {}", dataMap.get("abc"));
		logger.debug("I am CronJob, JobDataMap_2 : {}", dataMap.get("aaa"));
		logger.debug("I am CronJob, JobDataMap_3 : {}", dataMap.get("bbb"));
	}
	
}
