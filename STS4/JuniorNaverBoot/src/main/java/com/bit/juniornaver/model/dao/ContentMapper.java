package com.bit.juniornaver.model.dao;

import java.util.List;
import java.util.Map;

import com.bit.juniornaver.model.vo.ContentBean;

public interface ContentMapper {

	List<ContentBean> getContentListBy(Map<String, Object> map);

	ContentBean getContent(int id);
	
	void upViewCount(int id);
	
}
