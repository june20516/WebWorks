package com.bit.juniver.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniver.model.dao.CharacterMapper;
import com.bit.juniver.model.dao.QnAMapper;
import com.bit.juniver.model.dto.CharacterBean;
import com.bit.juniver.model.dto.QnABean;

@Service("QnAService")
public class QnAServiceImpl implements QnAService{
	@Autowired
	QnAMapper qnAMapper;

	@Override
	public int writeQnA(QnABean qnA) {
		
		return qnAMapper.writeQnA(qnA);
	}

	@Override
	public List<QnABean> getQnAList() {
		// TODO Auto-generated method stub
		return qnAMapper.getQnAList();
	}

	@Override
	public QnABean getQnA(int qNo) {
		// TODO Auto-generated method stub
		return qnAMapper.getQnA(qNo);
	}

	@Override
	public int correctQnA(QnABean qnA) {
		// TODO Auto-generated method stub
		return qnAMapper.correctQnA(qnA);
	}

	@Override
	public int deleteQnA(int qNo) {
		// TODO Auto-generated method stub
		return qnAMapper.deleteQnA(qNo);
	}

	
	
	
}
