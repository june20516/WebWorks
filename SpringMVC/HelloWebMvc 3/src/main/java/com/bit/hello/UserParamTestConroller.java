package com.bit.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.model.User;
@Controller
public class UserParamTestConroller {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("param/poc1.xxx")
	public void paramObjectCall(User user) {
		logger.info("매개변수 user :"+user);
	}
	
	@RequestMapping("param/poc2.xxx")
	public void paramObjectCall2(@ModelAttribute User bb) {
		logger.info("매개변수 user :"+bb);
	}
	
	
}
