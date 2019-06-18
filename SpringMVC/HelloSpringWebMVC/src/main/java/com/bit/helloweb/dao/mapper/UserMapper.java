package com.bit.helloweb.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.helloweb.dto.User;

public interface UserMapper {
	List<User> findUserList();
	User findUser( @Param("id") String id, @Param("pw") String pw);
	void insertUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
}
