package com.bit.juniver.model.service;

import java.util.List;

import com.bit.juniver.model.dto.ArticleBean;

public interface ContentService {
	
	//DB 의 칼럼명을 저장한 final 변수
	final String MENU = "menu_id";
	final String CHARACTER = "character_id";
	
	/**
	 * 
	 * @param base = {MENU : menu_id, CHARACTER : character_id}
	 * @param id
	 * @return
	 */
	List<ArticleBean> getContentListBy(String base, int id);

	ArticleBean getContent(int articleId);

}
