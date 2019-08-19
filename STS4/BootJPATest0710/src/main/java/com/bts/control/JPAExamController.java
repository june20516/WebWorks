package com.bts.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;

@Controller
public class JPAExamController {
	@Autowired
	private MemberRepository memberRepository;

	@RequestMapping("/add")
	@ResponseBody // 출력이 필요할 경우 사용
	public List<Member> add() {
		List<Member> members = new ArrayList<>();
		members.add(new Member());
		members.add(new Member());
		members.add(new Member());
		return members;
	}

	@RequestMapping("/add2")
	@ResponseBody
	public Member add2(Member member) {
		Member mem = memberRepository.save(member);
		return mem;
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Member> list() {
		List<Member> mem = memberRepository.findAll();
		return mem;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public List<Member> delete(Member member) {
		memberRepository.deleteById(member.getId());
		List<Member> mem = memberRepository.findAll();
		return mem;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Member update(Member member) {
		if (memberRepository.existsById(member.getId())) {
			Member mem = memberRepository.save(member);
			member.setPassword(member.getPassword());
			mem = memberRepository.save(member);
			return mem;
		}
		return null;
	}

	///////////////////////////////////////////////////////////

	@RequestMapping("/email")
	@ResponseBody
	public List<Member> searchEmail(String email) {
		// http://localhost/email?email=sy423513@gmail.com
		return memberRepository.findByEmail(email);
	}

	@RequestMapping("/emailQuery")
	@ResponseBody
	public List<Member> emailQuery(String email) {
		return memberRepository.findByEmailQueryNative(email);
	}

}
