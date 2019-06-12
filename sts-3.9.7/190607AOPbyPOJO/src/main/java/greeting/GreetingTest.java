package greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GreetingTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		GreetingService bean = (GreetingService) ctx.getBean("greetingTarget");
		bean.sayHello("bran");
		
	}

}
