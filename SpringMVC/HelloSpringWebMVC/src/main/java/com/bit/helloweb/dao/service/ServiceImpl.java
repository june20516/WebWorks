package com.bit.helloweb.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.helloweb.dao.mapper.UserMapper;
import com.bit.helloweb.dto.User;


@Service("userService")
public class ServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public List<User> allUser() {
		return userMapper.findUserList();
	}

	@Override
	public User infoUser(String id, String pw) {		
		return userMapper.findUser(id, pw);
	}

}
