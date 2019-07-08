package com.bit.juniver.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniver.model.dao.LoginMapper;
import com.bit.juniver.model.dao.JoinMapper;
import com.bit.juniver.model.dto.MemberBean;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	LoginMapper loginMapper;
	@Autowired
	JoinMapper joinMapper;
	
	@Override
	public MemberBean findUserByIdAndPassword(String id, String password) {
		
		return loginMapper.findUserByIdAndPassword(id,password);
	}

	@Override
	public boolean isDuplicatedId(String id) {
		
		return joinMapper.countId(id) != 0;
	}

	@Override
	public void registerMember(MemberBean memberBean) {
		joinMapper.registerMember(memberBean);
	}

}
