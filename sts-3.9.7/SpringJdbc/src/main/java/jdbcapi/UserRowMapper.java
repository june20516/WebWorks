package jdbcapi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	
	public void name() {
		
	}
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setPassword(rs.getString("PW")); 
		user.setName(rs.getString("NAME"));
		user.setUserId(rs.getString("ID"));
		return user;
	}
	
}
