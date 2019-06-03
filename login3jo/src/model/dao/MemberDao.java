package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dto.MemberDto;

public class MemberDao {

	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;

	private Connection conn;
	private PreparedStatement pStmt;
	private ResultSet result;

	private static MemberDao instance = new MemberDao();

	private MemberDao() {
		connection();
	}

	private void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.44:1521:xe", "kwon", "kwon");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDao getInstance() {
		return instance;
	}

	public int insertMember(MemberDto dto) {
		int ri = 0;
		String sql = "insert into members values (?,?,?)";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dto.getId());
			pStmt.setString(2, dto.getPw());
			pStmt.setString(3, dto.getName());
			pStmt.executeUpdate();
			ri = MemberDao.MEMBER_JOIN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				if (pStmt != null)
//					pStmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		return ri;
	}

	public int confirmId(String id) {
		int ri = 0;
		String sql = "select id from members where id = ?";

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			result = pStmt.executeQuery();
			if (result.next()) {
				ri = MemberDao.MEMBER_EXISTENT;
			} else {
				ri = MemberDao.MEMBER_NONEXISTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				result.close();
//				pStmt.close();
//				conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		return ri;
	}

	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;

		String sql = "select pw from members where id = ?";

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			result = pStmt.executeQuery();

			if (result.next()) {
				dbPw = result.getString("pw");
				if (dbPw.equals(pw)) {
					ri = MemberDao.MEMBER_LOGIN_SUCCESS; // 로그인 Ok
				} else {
					ri = MemberDao.MEMBER_LOGIN_PW_NO_GOOD; // 비번 X
				}
			} else {
				ri = MemberDao.MEMBER_LOGIN_IS_NOT; // 회원 X
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				result.close();
//				pStmt.close();
//				conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		return ri;
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
//		finally {
//			try {
//				set.close();
//				pstmt.close();
//				connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		return dto;
	}

	public int updateMember(MemberDto dto) {
		int ri = 0;

		String sql = "update members set pw=?, name=? where id=?";

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dto.getPw());
			pStmt.setString(2, dto.getName());
			pStmt.setString(3, dto.getId());
			ri = pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				pStmt.close();
//				conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		return ri;
	}

}
