package greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class GreetingServiceImpl implements GreetingService{
	
	@Autowired
	OutputService outputter;
	
	String greeting;
	

	public GreetingServiceImpl() {
		Logger logger = LoggerFactory.getLogger("OutputServiceImpl");
		logger.info("그리팅서비스임플리먼트 생성자 실행");
	}
	
	@Override
	public void setOutputter(OutputService outputter) {
		this.outputter = outputter;
		System.out.println("그리팅서비스임플리먼트의 메소드 setOutputter실행 : " + outputter);
	}

	@Override
	public void sayHello(String name) {
		System.out.println( this.greeting + ", "+name+" ! ");		
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	

}
