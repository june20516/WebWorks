package p55.byname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServiceImpl implements GreetingService{
	
	OutputService outputter;
	

	public GreetingServiceImpl() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl");
		logger.info("그리팅서비스임플리먼트 생성자 실행");
	}
	
	@Override
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
		System.out.println("그리팅서비스임플리먼트의 메소드 setOutputter실행 : " + outputter);
	}
	
	

}
