package com.bit.juniver.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.juniver.model.dto.QnABean;
import com.bit.juniver.model.service.QnAService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Q_AController {
	
	private static final Logger logger = LoggerFactory.getLogger(Q_AController.class);
	
	@Autowired
	private QnAService qnAService;
	
	@RequestMapping(value = "/QnA", method = RequestMethod.GET)
	public String QnA(Model model) {
		// 모든 질문 가져오기
		List<QnABean> qnAs = qnAService.getQnAList();
		// 리턴할 페이지로 질문리스트 넘기기
		model.addAttribute("qnAs", qnAs);

		return "qna/qnaList";
	}
	
	@RequestMapping(value = "/QnAView", method = RequestMethod.GET)
	public String QnAView(@RequestParam int qNo, Model model) {
		// 선택된 질문 가져오기
		QnABean qnA = qnAService.getQnA(qNo);
		// 리턴할 페이지로 질문 넘기기
		model.addAttribute("qnA", qnA);
		
		return "qna/qnaView";
	}
	
	@RequestMapping(value = "/QnAWrite", method = RequestMethod.GET)
	public String QnAWrite(QnABean qnA, Model model) {
		// 질문 등록하기
		int result = qnAService.writeQnA(qnA);
		model.addAttribute("isInserted",(result!=0));
		return "forward:/QnA";
	}
	
	@RequestMapping("/QnAWriter")
	public String QnAWriter() {
		return "qna/qnaWriter";
	}
	
	@RequestMapping(value = "/QnACorrect", method = RequestMethod.GET)
	public String QnACorrect(QnABean qnA, Model model) {
		// 질문 수정하기
		int result = qnAService.correctQnA(qnA);
		model.addAttribute("isInserted",(result!=0));
		return "forward:/QnA";
	}
	
	
}
