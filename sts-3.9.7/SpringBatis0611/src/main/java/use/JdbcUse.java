package use;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDAO;
import dto.User;

public class JdbcUse {

	public static void main(String[] args) {

		ApplicationContext acx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDAO userDao = acx.getBean("userDAO", UserDAO.class);
//		UserDAO userDao = acx.getBean("userDAO2", UserDAO.class);

		User newUsr = new User("kentucky4", "mustard", "delecious");
		userDao.insertUser(newUsr);
		
		List<User> userList = userDao.findUserList();
		for(User usr : userList) {
		System.out.println(" ID : " + usr.getId() + " / Name : " + usr.getName() + " / password : " + usr.getPw());
		}
		
		
		
	}

}
