package com.bit.juniornaver.model.service;

import java.util.List;

import com.bit.juniornaver.model.vo.ContentBean;

public interface ContentService {
	
	final String MENU = "menu_id";
	final String CHARACTER = "character_id";
	
	/**
	 * 
	 * @param base = {MENU : menu_id, CHARACTER : character_id}
	 * @param id
	 * @return
	 */
	List<ContentBean> getContentListBy(String base, int id);

	ContentBean getContent(int articleId);

}
