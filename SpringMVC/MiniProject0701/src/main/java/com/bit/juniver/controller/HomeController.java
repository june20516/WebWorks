package com.bit.juniver.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.juniver.model.dto.CharacterBean;
import com.bit.juniver.model.dto.ContentBean;
import com.bit.juniver.model.dto.MenuBean;
import com.bit.juniver.model.service.CharacterService;
import com.bit.juniver.model.service.ContentService;
import com.bit.juniver.model.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	MenuService menuService;
	@Autowired
	CharacterService characterService;
	
	@Autowired
	ContentService contentService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(defaultValue="1") String menu, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		int menuId = Integer.parseInt(menu);
		List<MenuBean> menus = menuService.listAllMenus();
		List<CharacterBean> characters = characterService.getAllCharacters(menuId);
		List<ContentBean> contents = contentService.getContentListBy(ContentService.MENU,menuId);

			model.addAttribute("menus", menus);
			model.addAttribute("characters", characters);
			model.addAttribute("contents",contents);
		
		return "content/home";
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.GET)
	public String character(@RequestParam int id, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<MenuBean> menus = menuService.listAllMenus();
		List<ContentBean> contents = contentService.getContentListBy(ContentService.CHARACTER,id);
		CharacterBean character = characterService.getCharacter(id);
			model.addAttribute("menues",menus);
			model.addAttribute("contents",contents);
			model.addAttribute("character",character);
		
		return "content/character";
	}

}
