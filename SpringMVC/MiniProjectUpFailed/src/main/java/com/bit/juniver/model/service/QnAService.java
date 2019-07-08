package com.bit.juniver.model.service;

import java.util.List;

import com.bit.juniver.model.dto.QnABean;

public interface QnAService {
	List<QnABean> getList();
	
	QnABean qnaView(int qNo);
	
	void qnaWrite(QnABean qnaBean);
	
	void qnaUpdate(QnABean qnaBean);
	
	void qnaDelete(int qNo);
}
