package jdbcapi;

import java.util.List;


public class UserDAOImpl extends UserDAO {

	@Override
	public List<User> findUserList() {
		String sql = "SELECT ID,PW,NAME FROM MEMBERS";
		UserRowMapper rowMapper = new UserRowMapper();
		return getJdbcTemplate().query(sql, rowMapper);
	}

	@Override
	public int insertUser(User user) {
		String id = user.getUserId();
		String pw = user.getPassword();
		String name = user.getName();
//		String sql = "INSERT INTO MEMBERS (ID,PW,NAME) VALUES ('"+id+"','"+pw+"','"+name+"')";		
//		return getJdbcTemplate().update(sql);
		String sql = "INSERT INTO MEMBERS (ID,PW,NAME) VALUES (?,?,?)";		
		return getJdbcTemplate().update(sql, id, pw, name);
	}
	
}
