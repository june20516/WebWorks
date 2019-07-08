package com.bit.juniornaver.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.juniornaver.model.service.CharacterService;
import com.bit.juniornaver.model.service.ContentService;
import com.bit.juniornaver.model.service.MenuService;
import com.bit.juniornaver.model.vo.HomeBean;

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
	public String home(@RequestParam(defaultValue="1") String menu, Locale locale, HomeBean home) {
		logger.info("Welcome home! The client locale is {}.", locale);
		int menuId = Integer.parseInt(menu); 
		home.setMenus(menuService.listAllMenus());
		home.setAllCharacters(characterService.getAllCharacters(menuId));
		home.setContents(contentService.getContentListBy(ContentService.MENU,menuId));
		
		return "content/home";
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.GET)
	public String character(@RequestParam int id, Locale locale, HomeBean home) {
		logger.info("Welcome home! The client locale is {}.", locale);
		home.setMenus(menuService.listAllMenus());
		home.setCharacter(characterService.getCharacter(id));
		home.setContents(contentService.getContentListBy(ContentService.CHARACTER,id));
		
		return "content/character";
	}

}
