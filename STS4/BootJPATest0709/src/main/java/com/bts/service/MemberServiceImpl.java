package com.bts.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;

public class MemberServiceImpl implements MemberService {
@Autowired
private MemberRepository memberRepository;

@Override
public void updateId(int id, Member member) {
	// TODO Auto-generated method stub
	// id 일치하는 자료의 값을 갱신
	// ??? 1.id에 일치하는 멤버인스턴스를 리턴받는다.
	Member tempMember = memberRepository.findById(id);
	
	
}


	
}
