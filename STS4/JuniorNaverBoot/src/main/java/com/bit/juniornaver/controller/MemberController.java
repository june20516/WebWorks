package com.bit.juniornaver.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.juniornaver.model.service.MemberService;
import com.bit.juniornaver.model.vo.MemberBean;

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
	public Map<String, Boolean> idCheck(@RequestBody String usrId, Model model) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("isDupl",memberService.isDuplicatedId(usrId));
		
		return map;
	}

	@RequestMapping("joinProcess")
	public String joinProcess(MemberBean memberBean) {
		try {
			memberService.registerMember(memberBean);
			logger.info("member register complete - " + memberBean);
			return "redirect:login";
		} catch (Exception e) {
			logger.warn("member register fail - " + e.getMessage());
			return "member/login";
		}
	}

	// 로그인 화면
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 로그인 처리
	@RequestMapping(value = "loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(MemberBean bean, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		MemberBean loginUser = memberService.findByUserId(bean.getId());
		if (loginUser != null) {
			session.setAttribute("userLoginInfo", loginUser);
		}
		return mav;
	}

}
