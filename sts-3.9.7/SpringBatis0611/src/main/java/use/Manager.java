package use;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.UserMapper;
import dto.User;


public class Manager {
	
	private String resource="mybatis/config/mybatis-config.xml";
	private SqlSessionFactory sessionFactory;
	
	public Manager() throws IOException {		
		Reader reader = Resources.getResourceAsReader(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public List<User> findUserList() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.findUserList();
		return users;
	}
	
	

	public void insertUser(User user) {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.insertUser(user.getId(), user.getPw(), user.getName());
		System.out.println("쿼리실행");

	}
}
