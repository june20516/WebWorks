package com.bts.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bts.dao.MemberRepository;
import com.bts.dto.Member;

@Controller
public class JPAExamController {
		@Autowired
		MemberRepository memberRepository;
	
	
		@RequestMapping("/add")
		@ResponseBody
		public List<Member> add() {
			List<Member> members = new ArrayList<Member>();
			members.add(new Member());
			members.add(new Member());
			members.add(new Member());
			return members;
		}
		
		@RequestMapping("/add2")
		@ResponseBody
		public Member add2(Member member) {
			System.out.println(member);
			Member memberData = memberRepository.save(member);
			return memberData;
		}
		
		@RequestMapping("/list")
		@ResponseBody
		public List<Member> findAll() {
			List<Member> memberList = memberRepository.findAll();
			return memberList;
		}

		@RequestMapping("/one")
		@ResponseBody
		public Member findOne(Integer id) {
			Optional<Member> member = memberRepository.findById(id);
			return member.get();
		}
		
		@RequestMapping("/delete")
		public String deleteMember(int id) {
			memberRepository.deleteById(id);
			return "/list";
		}

		@RequestMapping("/test")
		public String test() {
			return "forward:/list";
		}
			
		
	
}
