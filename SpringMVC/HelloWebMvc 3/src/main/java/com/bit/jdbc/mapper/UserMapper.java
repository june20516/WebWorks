package com.bit.jdbc.mapper;

import java.util.List;

import com.bit.model.User;

public interface UserMapper {

	List<User> findUserList();
}
