package p55.bytype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputServiceImpl2 implements OutputService2{
	
	
	public OutputServiceImpl2() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl2");
		output();
		logger.info("아웃풋서비스임플리먼트2 생성자 실행");
	}
	
	@Override
	public void output() {
		System.out.println("아웃풋서비스임플리먼트2의 메소드 output 실행 " + this.getClass());
	}

	
}
