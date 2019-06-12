package p55.byconstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServiceImpl3 implements GreetingService3{
	
	OutputService3 outputter;
	

	public GreetingServiceImpl3(OutputService3 outputter) {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl3");
		logger.info("그리팅서비스임플리먼트3 생성자 실행");
		setOutputter(outputter);
	}
	
	@Override
	public void setOutputter(OutputService3 outputter) {
		this.outputter = outputter;
		System.out.println("그리팅서비스임플리먼트3의 메소드 setOutputter실행 : " + outputter);
	}


	
	

}
