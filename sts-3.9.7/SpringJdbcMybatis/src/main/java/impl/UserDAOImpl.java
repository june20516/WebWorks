package impl;

import java.util.List;

import dao.UserDAO;
import dto.User;
import mapper.UserRowMapper;


public class UserDAOImpl extends UserDAO {

//	@Override
//	public List<User> findUserList() {
//		String sql = null;
//		UserRowMapper rowMapper = new UserRowMapper();
//		return getJdbcTemplate().query(sql, rowMapper);
//	}
	@Override
	public List<User> findUserList() {
		
		return null;
	}

	@Override
	public int insertUser(User user) {
		String id = user.getId();
		String pw = user.getPw();
		String name = user.getName();
//		String sql = "INSERT INTO MEMBERS (ID,PW,NAME) VALUES ('"+id+"','"+pw+"','"+name+"')";		
//		return getJdbcTemplate().update(sql);
		String sql = "INSERT INTO MEMBERS (ID,PW,NAME) VALUES (?,?,?)";		
		return getJdbcTemplate().update(sql, id, pw, name);
	}
	
}
