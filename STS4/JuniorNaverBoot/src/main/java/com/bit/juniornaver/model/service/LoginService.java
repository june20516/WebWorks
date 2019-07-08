package com.bit.juniornaver.model.service;

import com.bit.juniornaver.model.vo.MemberBean;

public interface LoginService {
	public MemberBean findByUserIdAndPassword(String id, String password);
}
