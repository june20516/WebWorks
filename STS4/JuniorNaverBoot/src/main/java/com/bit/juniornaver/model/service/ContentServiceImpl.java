package com.bit.juniornaver.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniornaver.model.dao.ContentMapper;
import com.bit.juniornaver.model.vo.ContentBean;

@Service("ContentService")
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	ContentMapper contentMapper;
	
	@Override
	public List<ContentBean> getContentListBy(String base, int id) {
		System.out.println("get contents list where menu id : " + id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("base", base);
		map.put("id", id);		
		return contentMapper.getContentListBy(map);
	}

	@Override
	public ContentBean getContent(int articleId) {
		System.out.println("get a content where content id : " + articleId);
		contentMapper.upViewCount(articleId);
		return contentMapper.getContent(articleId);
	}

}
