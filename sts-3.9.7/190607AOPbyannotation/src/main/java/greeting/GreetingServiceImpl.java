package greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="greetingTarget")
public class GreetingServiceImpl implements GreetingService{
	
	
	OutputService outputter;
	
	String greeting;
	

	public GreetingServiceImpl() {
		Logger logger = LoggerFactory.getLogger("GreetingServiceImpl");
		logger.info("그리팅서비스임플리먼트 생성자 실행");
		this.greeting = "Hello";
	}
	
	@Override
	@Autowired
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
