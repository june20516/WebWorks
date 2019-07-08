package com.bit.juniornaver.model.service;

import com.bit.juniornaver.model.vo.MemberBean;

public interface MemberService {
	
	MemberBean findByUserIdAndPassword(String id, String password);
	
	boolean isDuplicatedId(String id);

	void registerMember(MemberBean memberBean);

	MemberBean findByUserId(String id);
	
	
}
