package com.bit.juniornaver.model.service;

import java.util.List;

import com.bit.juniornaver.model.vo.QnABean;

public interface QnAService {
	List<QnABean> getList();
	
	QnABean qnaView(int qNo);
	
	void qnaWrite(QnABean qnaBean);
	
	void qnaUpdate(QnABean qnaBean);
	
	void qnaDelete(int qNo);

}
