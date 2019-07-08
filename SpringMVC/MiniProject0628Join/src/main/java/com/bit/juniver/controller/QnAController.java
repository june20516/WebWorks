package com.bit.juniver.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.juniver.model.dto.QnABean;
import com.bit.juniver.model.service.ImageService;
import com.bit.juniver.model.service.QnAService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QnAController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	
	@Autowired
	QnAService qnaService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping("qnaList")
	public String qnaList(Locale locale, Model model) {
		List<QnABean> qnaListAll = qnaService.getList();
		model.addAttribute("qnaList", qnaListAll);
		return "qna/qnaList";
	}
	
	@RequestMapping("qnaView")
	public ModelAndView qnaView(int qNo, ModelAndView mav) {
		QnABean view = qnaService.qnaView(qNo);
		mav.setViewName("qna/qnaView");
		mav.addObject("qna", view);
		return mav;
	}
	
	@RequestMapping("qnaWriter")
	public String qnaWriter() {
		return "qna/qnaWriter";
	}
	
	
	@RequestMapping("qnaRegister")
	public String qnaRegister(QnABean qnaBean) {
		if(qnaBean.getqNo() == 0) {
			qnaService.qnaWrite(qnaBean);
		}else {
			qnaService.qnaUpdate(qnaBean);
		}	
		return "redirect:qnaList";
	}
	
	@RequestMapping("image")
	public void image(MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
		ImageService imageService = new ImageService();
		try {
			imageService.fileUpload(file, request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="qnaUp", method=RequestMethod.POST)
	public String update(QnABean qnaBean) {
		System.out.println(qnaBean);
		return "qna/qnaWriter";
	}
	
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public String delete(int qNo) {
		qnaService.qnaDelete(qNo);
		return "redirect:qnaList";
	}
	
}
