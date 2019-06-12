package p55.bytype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServiceImpl2 implements GreetingService2{
	
	OutputService2 outputter;
	

	public GreetingServiceImpl2() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl2");
		logger.info("그리팅서비스임플리먼트2 생성자 실행");
	}
	
	@Override
	public void setOutputter(OutputService2 outputter) {
		this.outputter = outputter;
		System.out.println("그리팅서비스임플리먼트2의 메소드 setOutputter실행 : " + outputter);
	}


	
	

}
