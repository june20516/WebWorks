package model.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
		} catch (SQLException e) {
			System.out.println("code : " + e.getErrorCode() + ", message : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("message : " + e.getLocalizedMessage());
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
