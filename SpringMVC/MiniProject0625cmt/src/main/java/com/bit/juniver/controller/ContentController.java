package com.bit.juniver.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.juniver.model.dto.ArticleBean;
import com.bit.juniver.model.dto.CharacterBean;
import com.bit.juniver.model.service.CharacterService;
import com.bit.juniver.model.service.ContentService;

/**
 * 
 */
@Controller
public class ContentController {
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	//캐릭터 서비스 연결
	@Autowired
	private CharacterService characterService;
	
	//컨텐츠 서비스 연결
	@Autowired
	private ContentService contentService;
	
	/**
	 *  동영상이 재생되는 페이지뷰 컨트롤러
	 *  @param article id
	 *  @author junholee
	 */
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public String article(@RequestParam String id, Model model) {
		logger.info(this.getClass().getName());
		//받은 id를 정수로 변환 (개선필요) 
		int articleId = Integer.parseInt(id);
		//해당 id의 컨텐츠를 가져온다.
		ArticleBean article = contentService.getContent(articleId);
		logger.info("characterId : " + article.getCharacter_id());
		//해당 id의 캐릭터를 가져온다.
		CharacterBean character = characterService.getCharacter(article.getCharacter_id());
		logger.info("characterBean : " + character);
		// 컨텐츠와 캐릭터를 리턴할 페이지로 넘긴다.
		model.addAttribute("article",article);
		model.addAttribute("character",character);
		
		return "content/article";
	}
	
}
