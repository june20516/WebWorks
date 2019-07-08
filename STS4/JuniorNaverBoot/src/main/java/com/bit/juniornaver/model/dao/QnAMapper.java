package com.bit.juniornaver.model.dao;

import java.util.List;

import com.bit.juniornaver.model.vo.QnABean;

public interface QnAMapper {
	List<QnABean> getList();
	
	QnABean qnaView(int qNo);
	
	void qnaWrite(QnABean qnaBean);
	
	void qnaUpdate(QnABean qnaBean);
	
	void qndDelete(int qNo);
	
}