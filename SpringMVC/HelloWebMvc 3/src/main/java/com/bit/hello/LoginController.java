package com.bit.hello;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.jdbc.DAO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("loginStartOld")
	public String loginStartOld() {
		return "login/login";
	}
	
	
	@RequestMapping("loginRedirect")
	public String loginStartRedirect() {
		return "redirect:login/login.jsp";
	}
	
	@RequestMapping("loginRdOk")
	public String loginStartRedirect2() {
		return "redirect:loginOld2.do";
	}
	
	/**
	 * http://localhost:8080/hello/login/login.start 호출
	 * WEB-INF/views/login/login.jsp 화면 출력
	 */
	@RequestMapping("login/login.start")
	public void loginStart() {
		//return "login/login";
	}
	@RequestMapping("loginOld1.do")
	public String loginProcessOld1() {
		return "welcome";
	}
	
	
	@RequestMapping("loginOld2.do")
	public String loginProcessOld2(Model model) {
		model.addAttribute("name","범홍");
		model.addAttribute("name2", "명우");
		return "welcome";
	}
	
	@RequestMapping("loginMav.do")
	public ModelAndView loginProcessOld2x() {
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("name","범홍");
		mav.addObject("name2", "명우");
		return mav;
	}
	
	@RequestMapping("loginOld3.do")
	public String loginProcessOld3(Model model, HttpServletRequest req) {
		
		logger.info(req.getParameter("id"));
		model.addAttribute("name","범홍");
		model.addAttribute("name2", "명우");
		return "welcome";
	}
	@RequestMapping("login.do")
	public String loginProcess(Model model, String id, String pw) {
		logger.info(id+" "+pw);
		model.addAttribute("name",DAO.instance.getMember(id, pw));
		model.addAttribute("name2", "명우");
		return "welcome";
	}
	
	
}
