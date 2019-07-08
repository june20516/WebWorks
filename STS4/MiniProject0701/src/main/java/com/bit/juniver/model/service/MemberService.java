package com.bit.juniver.model.service;

import com.bit.juniver.model.dto.MemberBean;

public interface MemberService {
	
	MemberBean findByUserIdAndPassword(String id, String password);
	
	boolean isDuplicatedId(String id);

	void registerMember(MemberBean memberBean);

	MemberBean findByUserId(String id);
	
	
}
