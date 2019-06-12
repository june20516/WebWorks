package p55;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import p55.byautodetect.GreetingServiceImpl4;
import p55.byconstructor.GreetingServiceImpl3;
import p55.byname.GreetingServiceImpl;
import p55.bytype.GreetingServiceImpl2;

public class Go {
	public static void main(String[] args) {
		
//		Resource resource = new ClassPathResource("applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//byName
		GreetingServiceImpl greeting = (GreetingServiceImpl) factory.getBean("greeting");
		System.out.println("\n\n");
		
		//byType
		GreetingServiceImpl2 greeting2 = (GreetingServiceImpl2) factory.getBean("greeting2");
		System.out.println("\n\n");
		
		//byConstructor
		GreetingServiceImpl3 greeting3 = (GreetingServiceImpl3) factory.getBean("greeting3");
		System.out.println("\n\n");
		
		//byAutoDetect
		GreetingServiceImpl4 greeting4 = (GreetingServiceImpl4) factory.getBean("greeting4");
		System.out.println(greeting4.outputter);
		
	}
}
