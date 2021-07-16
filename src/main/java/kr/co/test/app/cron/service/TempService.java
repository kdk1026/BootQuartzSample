package kr.co.test.app.cron.service;

import org.springframework.stereotype.Service;

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
@Service
public class TempService extends LogDeclare {

	public void test() {
		logger.debug("I am Service Layer");
	}
	
}
