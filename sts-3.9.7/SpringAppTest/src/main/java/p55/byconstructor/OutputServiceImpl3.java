package p55.byconstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputServiceImpl3 implements OutputService3{
	
	
	public OutputServiceImpl3() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl3");
		output();
		logger.info("아웃풋서비스임플리먼트3 생성자 실행");
	}
	
	@Override
	public void output() {
		System.out.println("아웃풋서비스임플리먼트3의 메소드 output 실행 " + this.getClass());
	}

	
}
