package greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GreetingTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		GreetingService bean = (GreetingService) ctx.getBean("greetingTarget");
		bean.sayHello("bran");
		
	}

}
