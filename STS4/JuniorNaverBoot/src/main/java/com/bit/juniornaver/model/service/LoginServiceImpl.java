package com.bit.juniornaver.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniornaver.model.dao.LoginMapper;
import com.bit.juniornaver.model.vo.MemberBean;

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
