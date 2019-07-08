package com.bit.juniver.model.dao;

import java.util.List;

import com.bit.juniver.model.dto.QnABean;

public interface QnAMapper {
	List<QnABean> getList();
	
	QnABean qnaView(int qNo);
	
	void qnaWrite(QnABean qnaBean);
	
	void qnaUpdate(QnABean qnaBean);
	
	void qndDelete(int qNo);
	
}