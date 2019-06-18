package com.bit.hello;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.jdbc.DAO;

@Controller
public class LoginController {
	private static final Logger logger =
				LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("login")
	public String loginStart() {
		return "login/login";
	}
	@RequestMapping("loginOld1.do")
	public String loginProcessOld1() {
		return "welcome";
	}
	@RequestMapping("loginOld2.do")
	public String loginProcessOld2(Model model) {
		model.addAttribute("name","裹全");
		model.addAttribute("name2","疙快");
		return "welcome";
	}
	@RequestMapping("loginOld3.do")
	public String loginProcessOld3(Model model,HttpServletRequest req) {
		
		logger.info(req.getParameter("id"));
		model.addAttribute("name","裹全");
		model.addAttribute("name2","疙快");
		return "welcome";
	}
	@RequestMapping("loginOld4.do")
	public String loginProcessOld4(Model model,String id,String pw) {
		
		logger.info(id+" "+pw);
		
		model.addAttribute("name","裹全");
		model.addAttribute("name2","疙快");
		return "welcome";
	}
	@RequestMapping("login.do")
	public String loginProcess(Model model,String id,String pw) {
		logger.info(id+" "+pw);
		//db 立加 单捞鸥 啊廉咳
		model.addAttribute("name",DAO.instance.getMember(id, pw));
		model.addAttribute("name2","疙快");
		return "welcome";
	}

}










