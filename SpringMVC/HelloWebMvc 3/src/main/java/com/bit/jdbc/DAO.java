package com.bit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	static private Connection conn;	
	private PreparedStatement pStmt;		
	private ResultSet result;				


	//�씤�뒪�꽩�뒪--------------------
	static public Connection getConn() {

		return conn;

	}//getConn();

	static public final DAO instance;

	static {

		instance = new DAO();

	}

	private DAO() {

		connection();

	}

	//�뿰寃�-------------------
	private void connection() {

		try {
			//�뵒鍮꾩뿰寃고븷�븣 utf-8濡�
			String url = "jdbc:mysql://192.168.0.12:3306/team4?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, "taeyoung","8050");


			System.out.println("DB�뿰寃곗꽦怨�~!");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println(e.getErrorCode() + " " + e.getMessage() + " " + e.getSQLState());
		}

	}//connection(); 

	//�븳�궗�엺 �쉶�썝�젙蹂�
	public String getMember(String id,String pw) {
		String tempName = null;
		String sql = "select name from person where id = ? and pw = ?";

		try {

			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, pw);
			result = pStmt.executeQuery();
			if (result.next()) {
				return result.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return tempName;
	}
	



}