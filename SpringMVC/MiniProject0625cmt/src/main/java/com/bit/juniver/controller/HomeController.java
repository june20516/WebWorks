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
import com.bit.juniver.model.dto.ArticleBean;
import com.bit.juniver.model.dto.MenuBean;
import com.bit.juniver.model.service.CharacterService;
import com.bit.juniver.model.service.ContentService;
import com.bit.juniver.model.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// 매뉴 서비스 연결
	@Autowired
	MenuService menuService;
	// 캐릭터 서비스 연결
	@Autowired
	CharacterService characterService;
	// 컨텐츠 서비스 연결
	@Autowired
	ContentService contentService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * 
	 * 첫 화면 홈을 뿌려주는 컨트롤러
	 * 
	 * @param menu id. 디폴트 값 = 1(동요)
	 * @author junholee
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(defaultValue = "1") String menu, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		/**
		 * 받은 아이디를 정수형으로 변환 메서드의 parameter type을 변경하면 불필요한 작업이나, defaultValue를 지정하면
		 * String으로 고정되는 것 같음.
		 */
		int menuId = Integer.parseInt(menu);
		// 모든 매뉴 가져오기
		List<MenuBean> menus = menuService.listAllMenus();
		// 선택된 매뉴의 모든 캐릭터 가져오기
		List<CharacterBean> characters = characterService.getAllCharacters(menuId);
		// 선택된 매뉴의 모든 컨텐츠 가져오기
		List<ArticleBean> contents = contentService.getContentListBy(ContentService.MENU, menuId);
		// 리턴할 페이지로 매뉴, 캐릭터, 컨텐츠 넘기기
		model.addAttribute("menus", menus);
		model.addAttribute("characters", characters);
		model.addAttribute("contents", contents);

		return "content/home";
	}
	
	/**
	 *
	 * 캐릭터 뷰를 뿌려주는 컨트롤러
	 * 파라미터에 int라고 써놓으면 따로 정수형변환이 필요없다.
	 * @param character id
	 * @return
	 */
	@RequestMapping(value = "/character", method = RequestMethod.GET)
	public String character(@RequestParam int id, Model model) {
		//모든 매뉴 받아오기
		List<MenuBean> menus = menuService.listAllMenus();
		//선택한 캐릭터의 모든 컨텐츠 받아오기
		List<ArticleBean> contents = contentService.getContentListBy(ContentService.CHARACTER, id);
		//선택한 캐릭터 가져오기
		CharacterBean character = characterService.getCharacter(id);
		// 리턴할 페이지로 매뉴, 컨텐츠, 캐릭터 넘기기
		model.addAttribute("menues", menus);
		model.addAttribute("contents", contents);
		model.addAttribute("character", character);

		return "content/character";
	}

}
