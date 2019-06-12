package p55.byautodetect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputServiceImpl4 implements OutputService4{
	
	
	public OutputServiceImpl4() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl4");
		output();
		logger.info("아웃풋서비스임플리먼트4 생성자 실행");
	}
	
	@Override
	public void output() {
		System.out.println("아웃풋서비스임플리먼트4의 메소드 output 실행 " + this.getClass());
	}

	
}
