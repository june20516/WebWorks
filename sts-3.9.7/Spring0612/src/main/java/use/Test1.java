package use;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.dao.service.UserService;
import com.my.dto.User;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("root-context.xml");
		
		UserService service = ctx.getBean("userService",UserService.class);
		
		for(User usr : service.allUser()) {
		System.out.println(usr);
		}
	}

}
