package com.bit.juniver.model.dao;

import com.bit.juniver.model.dto.MemberBean;

public interface JoinMapper {

	int countId(String id);

	void registerMember(MemberBean memberBean);

}
