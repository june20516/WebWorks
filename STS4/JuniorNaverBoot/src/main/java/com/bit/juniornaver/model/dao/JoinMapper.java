package com.bit.juniornaver.model.dao;

import com.bit.juniornaver.model.vo.MemberBean;

public interface JoinMapper {

	int countId(String id);

	void registerMember(MemberBean memberBean);

}
