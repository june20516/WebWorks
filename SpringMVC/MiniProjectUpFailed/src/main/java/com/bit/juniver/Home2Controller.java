package com.bit.juniver;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.juniver.model.dto.CharacterBean;
import com.bit.juniver.model.dto.MenuBean;
import com.bit.juniver.model.service.CharacterService;
import com.bit.juniver.model.service.CharacterServiceImpl;
import com.bit.juniver.model.service.MenuService;
import com.bit.juniver.model.service.MenuServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Home2Controller {
//	@Autowired
//	MenuService menuService;
//	@Autowired
//	CharacterService characterService;
//	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model ) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		List<MenuBean> menus = menuService.listAllMenus();
//		model.addAttribute("menus", menus);
//		return "content/home";
//	}
//	
//	public String home2(Model model){
//		List<MenuBean> menus = menuService.listAllMenus();
//		model.addAttribute("menus", menus);
//		return "content/home";
//	}
//	@RequestMapping("article")
//	public String article() {
//		return "content/article";
//	}
//	
}
