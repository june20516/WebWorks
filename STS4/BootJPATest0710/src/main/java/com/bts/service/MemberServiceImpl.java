package com.bts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Override
	public void updateById(int id, Member member) {
		// id가 일치하는 자료의 데이터가 일치하는 자료의 값을 갱신
		//1.id에 일치하는 멤버 인스턴스를 리턴받는다.
		//2. 1에서 리턴받은 데이터를 setter를 통해서 수정
		Member tempMember = memberRepository.findById(id);
		//3. Repository save 명령을 사용한다.
		if(tempMember==null) {
			throw new ResourceAccessException("Critical KyungMin is Occured");
		} else {
			tempMember.setEmail(member.getEmail());
			tempMember.setPassword(member.getPassword());
			// 3. repo의 세이브 명령을 사용한다
			memberRepository.save(tempMember);
		}
		
		
	}

	

}
