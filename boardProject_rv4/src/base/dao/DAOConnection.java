package base.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOConnection {
	   
	   protected PreparedStatement pstmt;
	   protected Connection connection;
	   protected DAOConnection() {
		  if(connection==null) getConnection();
		  
	   }
	   private void getConnection() {
		      try {
		         Class.forName("com.mysql.jdbc.Driver");
//		         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "1234");
		         connection = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/twotwo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "hs", "123456");
		         connection.setAutoCommit(false);
		         
		         System.out.println("Connection Completed");
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.out.println("Connected Failed");
		      }
		      System.out.println("DB Connected");
		   }
	   @Override
	protected void finalize() throws Throwable {
		if(pstmt!=null)pstmt.close();
		if(connection!=null)connection.close();
		
	}
}
