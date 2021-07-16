package kr.co.test.app.simple.job;

import org.quartz.Job;
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
public class SimpleJob extends LogDeclare implements Job {
	
	private String name;

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.debug("I am SimpleJob, String : Hello {}", this.name);
	}
	
}
