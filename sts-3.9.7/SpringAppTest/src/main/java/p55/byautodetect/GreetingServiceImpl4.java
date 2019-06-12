package p55.byautodetect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingServiceImpl4 implements GreetingService4{
	
	public OutputService4 outputter;
	

	public GreetingServiceImpl4(OutputService4 outputter) {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl4");
		logger.info("그리팅서비스임플리먼트4 생성자 실행");
	}
	
	@Override
	public void setOutputter(OutputService4 outputter) {
		this.outputter = outputter;
		System.out.println("그리팅서비스임플리먼트4의 메소드 setOutputter실행 : " + outputter);
	}


	
	

}
