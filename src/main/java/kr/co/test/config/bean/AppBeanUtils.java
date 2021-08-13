package kr.co.test.config.bean;

import org.springframework.context.ApplicationContext;

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
 * @see https://kongeebol.tistory.com/9
 */
public class AppBeanUtils {
	
	private AppBeanUtils() {
		super();
	}

	public static Object getBean(String bean) {
		ApplicationContext applicationContext = ApplicationContextProvider.getCtx();
		return applicationContext.getBean(bean);
	}
	
}
