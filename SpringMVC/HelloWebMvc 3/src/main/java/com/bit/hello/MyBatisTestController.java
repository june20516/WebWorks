package com.bit.hello;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.jdbc.service.UserService;
import com.bit.jdbc.service.UserServiceImpl;
import com.bit.model.User;

@Controller("/")
public class MyBatisTestController {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisTestController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("allUser")
	public ModelAndView allUserCall() {
		ModelAndView mav = new ModelAndView("allUser");
		logger.info(this.getClass() + "allUserCall()");
		List<User> users = userService.allUser();
		mav.addObject("users", users);
		return mav;
	}
}
