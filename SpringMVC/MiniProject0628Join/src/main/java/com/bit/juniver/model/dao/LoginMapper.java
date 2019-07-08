package com.bit.juniver.model.dao;

import com.bit.juniver.model.dto.MemberBean;

public interface LoginMapper {

	public MemberBean findUserByIdAndPassword(String id, String password);

}
