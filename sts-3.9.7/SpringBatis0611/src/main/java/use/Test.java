package use;

import java.io.IOException;

import dto.User;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.insertUser(new User("eleven", "june", "2019"));
			
		for(User usr : manager.findUserList()) {
				System.out.println(usr);
			};
			
	}

}
