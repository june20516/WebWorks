package com.bit.helloweb.controler;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {
	 private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	   
//	   @RequestMapping("login")
//	   public String loginStart() {
//	      return "login/login";
//	   }
	   
	   @RequestMapping("login/login.start")
	   public void loginStart() {
//	      return "login/login";
	   }
	   
	   @RequestMapping("loginRedirect")
	   public String loginStartRedirect() {
		   return "redirect:login/login";
	   }
	   
	   
	   
	   @RequestMapping("loginOld1.do")
	   public String loginPorcessOld1() {
	      return "welcome";
	   }
	   
	   @RequestMapping("loginMav.do")
	   public ModelAndView loginPorcessOld2() {
	      ModelAndView mav = new ModelAndView("welcome");
	      mav.addObject("name", "동원");
	      mav.addObject("name2", "정동");
	      return mav;
	   }
	   
	   @RequestMapping("loginOld3.do")
	   public String loginPorcessOld3(Model model, HttpServletRequest req) {
	      logger.info(req.getParameter("id"));
	      model.addAttribute("name", "동원");
	      model.addAttribute("name2", "정동");
	      return "welcome";
	   }
	   
	   @RequestMapping("login.do")
	   public String loginPorcess(Model model, String id, String pw) { 
	      logger.info("id : " + id + "  pw : " + pw);
	      model.addAttribute("name", "");
	      model.addAttribute("name2", "정동");
	      return "welcome";
	   }
	}
