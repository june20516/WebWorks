package hello;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloSpringApp {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
	}

}
