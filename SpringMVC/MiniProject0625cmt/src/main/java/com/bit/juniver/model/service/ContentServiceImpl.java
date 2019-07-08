package com.bit.juniver.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniver.model.dao.ContentMapper;
import com.bit.juniver.model.dto.ArticleBean;

@Service("ContentService")
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	ContentMapper contentMapper;
	
	@Override
	public List<ArticleBean> getContentListBy(String base, int id) {
		System.out.println("get contents list where menu id : " + id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("base", base);
		map.put("id", id);
		return contentMapper.getContentListBy(map);
	}

	@Override
	public ArticleBean getContent(int articleId) {
		System.out.println("get a content where content id : " + articleId);
		contentMapper.upViewCount(articleId);
		return contentMapper.getContent(articleId);
	}

}
