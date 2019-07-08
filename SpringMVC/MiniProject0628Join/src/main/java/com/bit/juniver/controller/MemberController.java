package com.bit.juniver.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.juniver.model.dto.MemberBean;
import com.bit.juniver.model.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("join")
	public String join(Model model) {
		return "member/join";
	}
	
	
	
	@RequestMapping("idCheck")
	@ResponseBody
	public Map<String,Boolean> idCheck(@RequestParam String id, Model model) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		map.put("isDupl", memberService.isDuplicatedId(id));
		return map;
	}
	
	@RequestMapping("joinProcess")
	public String joinProcess(MemberBean memberBean) {
		try {
		memberService.registerMember(memberBean);
		logger.info("member register complete - " + memberBean);
		return "redirect:member/login";
		} catch(Exception e) {
			logger.warn("member register fail - " + e.getMessage());
			return "member/login";
		}
	}

}
