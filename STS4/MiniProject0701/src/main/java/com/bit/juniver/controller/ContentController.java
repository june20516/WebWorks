package com.bit.juniver.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.juniver.model.dto.ContentBean;
import com.bit.juniver.model.dto.CharacterBean;
import com.bit.juniver.model.service.CharacterService;
import com.bit.juniver.model.service.ContentService;

/**
 * 
 */
@Controller
public class ContentController {
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	@Autowired
	private CharacterService characterService;
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * 
	 */
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public String article(@RequestParam String id, Model model) {
		logger.info(this.getClass().getName());
		int articleId = Integer.parseInt(id);
		ContentBean article = contentService.getContent(articleId);
		logger.info("characterId : " + article.getCharacter_id());
		CharacterBean character = characterService.getCharacter(article.getCharacter_id());
		logger.info("characterBean : " + character);
		
		model.addAttribute("article",article);
		model.addAttribute("character",character);
		
		return "content/article";
	}
	
}
