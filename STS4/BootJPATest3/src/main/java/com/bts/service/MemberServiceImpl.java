package com.bts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void updateById(int id, Member member) {
		//id가 일치하는 자료의 data를 갱신
		// ???? 1. id에 일치하는 멤버 인스턴스를 리턴받는다.
		Member tempMember = memberRepository.findById(id);
		//		2. 1번에서 리턴받은 데이터를 setter를 통해 수정
		if (tempMember == null) {
			throw new ResourceAccessException("경민");
			//오늘의 과제 원하는 예외클래스를 만들기! ==> ResourceNotFoundException
			//uncheckedException으로 만들어 보세요 ==>
			//생성자에서는 엔티티의 이름, 필드명, 필드값 ==> 생성자
			//				("Member", "id", 41)
			//member.getClass().getName()
			//무엇이 어디에 없다는 메시지를 출력하고, 웹브라우저에 상태를 날린다.
			//Http상태값을 적용시킨다. ==> response에 대한 상태를 찾지 못했음을 알림
		}else {
			tempMember.setEmail(member.getEmail());
			tempMember.setPassword(member.getPassword());
			//		3. 레포지터리의 save명령 사용
			member = memberRepository.save(tempMember);
		}
	}
}	
