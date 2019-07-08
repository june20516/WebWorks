package com.bit.juniver.model.service;

import com.bit.juniver.model.dto.MemberBean;

public interface LoginService {
	public MemberBean findByUserIdAndPassword(String id, String password);
}
