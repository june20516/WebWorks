package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Member;

public interface MemberService {
	List<Member> selectAll();
}