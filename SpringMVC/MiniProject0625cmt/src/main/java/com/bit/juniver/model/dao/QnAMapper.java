package com.bit.juniver.model.dao;

import java.util.List;

import com.bit.juniver.model.dto.QnABean;

public interface QnAMapper {

	// 모든 질문 리스트를 가져온다
	List<QnABean> getQnAList();
	//질문 하나를 가져온다
	QnABean getQnA(int qNo);
	// 질문을 등록한다
	int writeQnA(QnABean qnA);
	// 질문을 수정한다
	int correctQnA(QnABean qnA);
	// 질문을 삭제한다
	int deleteQnA(int qNo);
	
}
