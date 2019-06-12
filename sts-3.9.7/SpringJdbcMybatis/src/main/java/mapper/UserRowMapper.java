package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dto.User;

public class UserRowMapper implements RowMapper<User> {

	
	public void name() {
		
	}
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setPw(rs.getString("PW")); 
		user.setName(rs.getString("NAME"));
		user.setId(rs.getString("ID"));
		return user;
	}
	
}
