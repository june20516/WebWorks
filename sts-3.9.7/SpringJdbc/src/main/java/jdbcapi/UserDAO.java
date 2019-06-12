package jdbcapi;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class UserDAO extends JdbcDaoSupport {
	
	
	abstract List<User> findUserList();
	
	abstract int insertUser(User user);
	
}
