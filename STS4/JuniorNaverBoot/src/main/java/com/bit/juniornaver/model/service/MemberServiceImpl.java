package com.bit.juniornaver.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniornaver.model.dao.JoinMapper;
import com.bit.juniornaver.model.dao.LoginMapper;
import com.bit.juniornaver.model.vo.MemberBean;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	LoginMapper loginMapper;
	@Autowired
	JoinMapper joinMapper;
	
	@Override
	public MemberBean findByUserIdAndPassword(String id, String password) {
		
		return loginMapper.findByUserIdAndPassword(id,password);
	}

	@Override
	public boolean isDuplicatedId(String id) {
		
		return joinMapper.countId(id) != 0;
	}

	@Override
	public void registerMember(MemberBean memberBean) {
		joinMapper.registerMember(memberBean);
	}

	@Override
	public MemberBean findByUserId(String id) {
		return loginMapper.findByUserId(id);
	}

}
