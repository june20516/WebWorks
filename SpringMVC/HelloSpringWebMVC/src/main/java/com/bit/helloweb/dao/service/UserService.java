package com.bit.helloweb.dao.service;

import java.util.List;

import com.bit.helloweb.dto.User;



public interface UserService {
	List<User> allUser();
	
	User infoUser(String id, String pw);
}
