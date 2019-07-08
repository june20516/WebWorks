package com.bit.juniornaver.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.juniornaver.model.dao.QnAMapper;
import com.bit.juniornaver.model.vo.QnABean;

@Service("QnAService")
public class QnAServiceImpl implements QnAService {

	@Autowired
	QnAMapper qnaMapper;
	
	@Override
	public List<QnABean> getList() {
		List<QnABean> bean = qnaMapper.getList();
		return bean;
	}
	@Override
	public QnABean qnaView(int qNo) {
		QnABean view = qnaMapper.qnaView(qNo);
		return view;
	}
	@Override
	public void qnaWrite(QnABean qnaBean) {
		qnaMapper.qnaWrite(qnaBean);
	}
	
	@Override
	public void qnaUpdate(QnABean qnaBean) {
		qnaMapper.qnaUpdate(qnaBean);
	}
	@Override
	public void qnaDelete(int qNo) {
		qnaMapper.qndDelete(qNo);
	}
	
}
