package com.bit.miniboard.model.service;

import java.util.List;

import com.bit.miniboard.model.dto.MemberBean;

public interface MemberService {

	List<MemberBean> allList();
	
	boolean isMember(MemberBean bean);
}
