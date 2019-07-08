package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberMapper;
import com.example.demo.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public List<Member> selectAll() {
		return memberMapper.selectAll();
	}

}