package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoConnection {
	private static Connection connection;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		connection = connection();
	}
	
	private static Connection connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lee", "lee");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print(e.getMessage());
		}
		return connection;
	}
	
	
}
