package com.bit.miniboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.miniboard.model.dto.MemberBean;
import com.bit.miniboard.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("login")
	public String login() {	
		return "member/login";
	}
	
	
	/**
	 * validate nickName and Password in the Member  bean by DB
	 * @param memberBean has nickname and password for check
	 */
	@RequestMapping(value="loginProcess", method= RequestMethod.POST)
	public String loginProcess(MemberBean memberBean) {
		String nextPage= memberService.isMember(memberBean) ? "forward:allList":"redirect:login";
		return nextPage;
	}
}
