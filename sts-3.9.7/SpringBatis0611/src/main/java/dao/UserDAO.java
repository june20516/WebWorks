package dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dto.User;

public abstract class UserDAO extends JdbcDaoSupport {
	
	
	public abstract List<User> findUserList();
	
	public abstract int insertUser(User user);
	
}
