package dao;

import java.util.List;

import dto.User;

public interface UserMapper {

	List<User> findUserList();
	
	void insertUser(String id, String pw, String name);
	
}
