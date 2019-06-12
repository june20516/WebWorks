package jdbcapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class UserDAOImpl2 extends UserDAO {


	

	@Override
	public List<User> findUserList() {
		String sql = "SELECT ID,PW,NAME FROM MEMBERS";
		UserRowMapper rowMapper = new UserRowMapper(); 
		List<User> userList = getJdbcTemplate().query(sql, rowMapper); 
		return userList;
	}

	@Override
	public int insertUser(final User user) {
		return getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO MEMBERS (ID,PW,NAME) VALUES (?,?,?)";
				PreparedStatement pStat = con.prepareStatement(sql);
				pStat.setString(1, user.getUserId());
				pStat.setString(2, user.getPassword());
				pStat.setString(3, user.getName());
				return pStat;
			}
		});	
	}
	
}
