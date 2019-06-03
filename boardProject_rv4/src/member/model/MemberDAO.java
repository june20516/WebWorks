package member.model;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;

import base.dao.DAOConnection;

//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;

public class MemberDAO extends DAOConnection {

	private ResultSet resultSet;

	public void insertMember(String id, String pw, String name, String tel1, String tel2, String tel3, String birth1,
			String birth2, String birth3, String sex, String email) {

		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, tel1);
			pstmt.setString(5, tel2);
			pstmt.setString(6, tel3);
			pstmt.setString(7, birth1);
			pstmt.setString(8, birth2);
			pstmt.setString(9, birth3);
			pstmt.setString(10, sex);
			pstmt.setString(11, email);
			System.out.println("Update");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void insertMember(MemberDTO member) {

		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			pstmt = connection.prepareStatement(query);
		/*	pstmt.setString(1, member.getId());
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, tel1);
			pstmt.setString(5, tel2);
			pstmt.setString(6, tel3);
			pstmt.setString(7, birth1);
			pstmt.setString(8, birth2);
			pstmt.setString(9, birth3);
			pstmt.setString(10, sex);
			pstmt.setString(11, email);*/
			System.out.println("Update");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int confirmId(String id) {
		int ri = 0;
		String query = "select id from member where id = ?";

		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				System.out.println("1");
				ri = 1;
			} else {
				System.out.println("2");
				ri = 2;
			}
		} catch (SQLException e) {
			System.out.println("3");
			e.printStackTrace();
		}
		return ri;
	}

	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw = "";

		String query = "select pw from member where id = ?";

		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			System.out.println(resultSet);
			System.out.println(pw);
			System.out.println("uc 값 담김!");

			if (resultSet.next()) {
				dbPw = (String) resultSet.getString("pw");
				System.out.println(dbPw + " = dbPw의 값");
				if (dbPw.equals(pw)) {
					System.out.println("로그인 성공했을 때 = " + ri + " = ri의 값");
					ri = 1; // 로그인 성공.
				} else {
					System.out.println("비번 틀렸을 때 = " + ri + " = ri의 값");
					ri = 0; // 비밀번호가 틀렸습니다.
				}
			} else {
				System.out.println("회원이 아닐 때 = " + ri + " = ri의 값");
				ri = -1; // 회원이 아닙니다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ri;

	}

	public MemberDTO getMember(String id) {

		String query = "select * from member where id = ?";
		MemberDTO dto = null;

		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				dto = new MemberDTO();
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pw"));
				dto.setName(resultSet.getString("name"));
				dto.setTel1(resultSet.getString("tel1"));
				dto.setTel2(resultSet.getString("tel2"));
				dto.setTel3(resultSet.getString("tel3"));
				dto.setBirth1(resultSet.getString("birth1"));
				dto.setBirth2(resultSet.getString("birth2"));
				dto.setBirth3(resultSet.getString("birth3"));
				dto.setSex(resultSet.getString("sex"));
				dto.setEmail(resultSet.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

//   private Connection getConnection() {
//      
//      Context context = null;
//      DataSource dataSource = null;
//      Connection connection = null;
//      
//      try {
//         context = new InitialContext();
//         dataSource = (DataSource)context.lookup(""); // DB url �Է�
//         connection = dataSource.getConnection();
//      } catch (Exception e) {
//         e.printStackTrace();
//      } 
//      return connection;
//   }

	@Override
	protected void finalize() throws Throwable {
		try {
			if (resultSet != null)
				resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.finalize();
	}
}