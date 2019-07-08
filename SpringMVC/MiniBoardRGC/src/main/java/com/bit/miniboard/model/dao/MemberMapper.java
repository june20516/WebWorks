package com.bit.miniboard.model.dao;

import java.util.List;

import com.bit.miniboard.model.dto.MemberBean;

public interface MemberMapper {
	
	List<MemberBean> allList();

	MemberBean getMemberInfo(MemberBean bean);
}
 