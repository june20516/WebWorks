package com.bit.juniver.model.service;

import java.util.List;

import com.bit.juniver.model.dto.CharacterBean;
import com.bit.juniver.model.dto.QnABean;

public interface QnAService {
	//c
	public int writeQnA(QnABean qnA);
	//r
	public List<QnABean> getQnAList();
	public QnABean getQnA(int qNo);
	//u
	public int correctQnA(QnABean qnA);
	//d
	public int deleteQnA(int qNo);
}
