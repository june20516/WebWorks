package com.bit.juniornaver.model.dao;

import org.apache.ibatis.annotations.Param;

import com.bit.juniornaver.model.vo.MemberBean;

public interface LoginMapper {
	public MemberBean findByUserIdAndPassword(@Param("id") String id, @Param("password") String password);
	public MemberBean findByUserId(String id);
}
