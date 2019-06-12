package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dto.MemberDto;

public class MemberDao {

	private Connection conn;
	private PreparedStatement pStmt;
	private ResultSet result;

	private static MemberDao instance = new MemberDao();

	private MemberDao() {
		conn = DaoConnection.getConnection();
	}

	public static MemberDao getInstance() {
		return instance;
	}

	public boolean insertMember(MemberDto dto) {
		String sql = "insert into members values (?,?,?)";
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
		String sql = "select id from members where id = ?";

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

		String sql = "select pw from members where id = ?";

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
		
		String sql = "select * from members where id = ?";
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
		String sql = "update members set pw=?, name=? where id=?";

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

}
