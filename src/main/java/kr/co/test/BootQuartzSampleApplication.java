package kr.co.test;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootQuartzSampleApplication {
	
	/**
	 * <pre>
	 * {@link <a href="https://wky.kr/13">Ref</a>}
	 * 
	 * 시간 출력 시, UTC 시간으로 출력을 KST로 변경
	 *   - 아마 AWS 등 외국 인프라인 경우에 해당하는 듯
	 *   
	 *   - 단, 로그 시간에는 영향 없음... 실행 시, 옵션 필요
	 *   	java -Duser.timezone=Asia/Seoul -jar 샬라샬라
	 *   
	 *   - 실행 할 때 옵션이면 이것도 필요 없을 거 같기는 하지만... 뭐 문제는 없으므로~
	 * </pre> 
	 */
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootQuartzSampleApplication.class, args);
	}

}
