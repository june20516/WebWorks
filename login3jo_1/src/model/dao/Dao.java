package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.dto.Content;
import model.dto.ContentsDto;
import model.dto.MemberDto;

public class Dao {

	private Connection conn;
	private PreparedStatement pStmt;
	private ResultSet result;

	private static Dao instance = new Dao();

	private Dao() {
		connection();
	}

	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@1.220.120.66:1521:xe", "lee", "lee");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lee", "lee");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Dao getInstance() {
		return instance;
	}

	public boolean insertMember(MemberDto dto) {
		String sql = "insert into system.login values (?,?,?)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dto.getId());
			pStmt.setString(2, dto.getPw());
			pStmt.setString(3, dto.getName());
			pStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean confirmId(String id) {
		String sql = "select id from system.login where id = ?";

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			result = pStmt.executeQuery();
			if (result.next()) {
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean userCheck(String id, String pw) {
		String dbPw;

		String sql = "select pw from system.login where id = ?";

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			result = pStmt.executeQuery();

			if (result.next()) {
				dbPw = result.getString("pw");
				if (dbPw.equals(pw)) {
					return true; 
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	public MemberDto getMember(String id) {
		
		String sql = "select * from system.login where id = ?";
		MemberDto dto = null;

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			result = pStmt.executeQuery();

			if (result.next()) {
				dto = new MemberDto();
				dto.setId(result.getString("id"));
				dto.setPw(result.getString("pw"));
				dto.setName(result.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dto;
	}

	public boolean updateMember(MemberDto dto) {
		String sql = "update system.login set pw=?, name=? where id=?";

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dto.getPw());
			pStmt.setString(2, dto.getName());
			pStmt.setString(3, dto.getId());
			pStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public void connectionExit() {
		try {
			result.close();
			pStmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void getContents() {
		String sql = "select BOARD.NO, BOARD.PARENT_NO, BOARD.TITLE, BOARD.CONTENT, BOARD.REG_DATE, BOARD.ID, LOGIN.NAME from system.board, system.login where system.board.id=system.login.id";
		HashMap<String,Content> contents = new HashMap<String,Content>();
		try {
			pStmt = conn.prepareStatement(sql);
			result = pStmt.executeQuery();
			while (result.next()) {
				Content content = new Content(
						result.getInt(1),	//no
						result.getInt(2),	//parent no
						result.getString(3),	//title
						result.getString(4),	//content
						result.getDate(5),	//reg_date
						result.getString(6),	//id
						result.getString(7)	// name
						);
				contents.put(content.getNo()+"",content);
				ContentsDto.setContents(contents);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public boolean wrightContent(String title, String content, String id) {
		String sql = "insert into system.board values(SYSTEM.SEQ_NO.NEXTVAL,?,?,?,SYSDATE,?)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, 0);
			System.out.println("title : " + title);
			pStmt.setString(2, title);
			System.out.println("content : " + content);
			pStmt.setString(3, content);
			System.out.println("id : " + id);
			pStmt.setString(4, id);
			pStmt.executeQuery();
			return true;
		} catch (SQLException sqle) {
			System.out.println(sqle.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean correctContent(String title, String content, int no) {
		String sql = "UPDATE SYSTEM.BOARD SET BOARD.TITLE=?, BOARD.CONTENT=? WHERE BOARD.NO=?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, title);
			pStmt.setString(2, content);
			pStmt.setInt(3, no);
			pStmt.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.getLocalizedMessage();
			return false;
		}
	}
	
	public boolean deleteContent(int no) {
		String sql = "delete from system.board where board.no=?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, no);
			pStmt.executeQuery();
			return true;
		} catch (SQLException sqle) {
			System.out.println(sqle.getLocalizedMessage());
			return false;
		}
	}
		
	
}
