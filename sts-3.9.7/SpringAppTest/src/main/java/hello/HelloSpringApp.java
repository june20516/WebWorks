package hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloSpringApp {
	public static void main(String[] args) {
	Resource resource = new ClassPathResource("applicationContext.xml");
	BeanFactory factory = new XmlBeanFactory(resource);
	HelloBean bean = (HelloBean)factory.getBean("helBe");
	bean.sayHello("Oak House");
	}
}
