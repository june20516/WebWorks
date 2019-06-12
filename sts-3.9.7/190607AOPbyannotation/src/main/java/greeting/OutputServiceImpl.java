package greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OutputServiceImpl implements OutputService{
	
	
	public OutputServiceImpl() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl");
		output();
		logger.info("아웃풋서비스임플리먼트 생성자 실행");
	}
	
	@Override
	public void output() {
		System.out.println("아웃풋서비스임플리먼트의 메소드 output 실행 " + this.getClass());
	}

	
}
