package com.bit.juniver.model.dao;

import java.util.List;
import java.util.Map;

import com.bit.juniver.model.dto.ArticleBean;

public interface ContentMapper {
	/**
	 * 특정 조건(매뉴or캐릭터)을 기준으로 모든 컨텐츠 리스트를 가져온다
	 * @param map
	 */
	List<ArticleBean> getContentListBy(Map<String, Object> map);
	//컨텐츠 하나를 가져온다
	ArticleBean getContent(int id);
	//조회수를 올린다
	void upViewCount(int id);
	
}
