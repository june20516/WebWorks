package com.bts.contol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;

@Controller
public class JPAExamController {
	@Autowired
	private MemberRepository memberRerpository;

	@RequestMapping("/add")
	@ResponseBody
	public List<Member> add() { // http://localhost/add
		List<Member> members = new ArrayList<>();
		members.add(new Member());
		members.add(new Member());
		members.add(new Member());
		return members;
	}

	@RequestMapping("/add2")
	@ResponseBody
	public Member add2(Member member) { // http://localhost/add
		Member mem = memberRerpository.save(member);
		return mem;
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Member> list() {
		return memberRerpository.findAll();
	}
	
	@RequestMapping("/email")
	@ResponseBody
	public List<Member> serachEmail(String email){
		//http://localhost/email?email=hs971022%40gmail.com
		return memberRerpository.findByEmail(email);
	}
	
	@RequestMapping("/emailQuery")
	@ResponseBody
	public List<Member> emailQuery(String email) {
		return memberRerpository.findByEmailQueryNative(email);
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Member> serachMember(String email,String password){
		return memberRerpository.findByEmailAndPassword(email, password);
	}

}
