package com.bit.juniver.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniver.model.dao.LoginMapper;
import com.bit.juniver.model.dto.MemberBean;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public MemberBean findByUserIdAndPassword(String id, String password) {
		// TODO Auto-generated method stub
		return loginMapper.findByUserIdAndPassword(id, password);
	}

}
