package com.bit.juniver.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.juniver.model.dto.QnABean;
import com.bit.juniver.model.dto.UploadFile;
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
	@Autowired
    ImageService imageService;
	
	
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
		System.out.println(qnaBean);
		if(qnaBean.getqNo() == 0) {
			qnaService.qnaWrite(qnaBean);
		}else {
			qnaService.qnaUpdate(qnaBean);
		}
			
		return "redirect:qnaList";
	}
	@RequestMapping(value="qnaUp", method=RequestMethod.POST)
	public String update(QnABean qnaBean) {
		return "qna/qnaWriter";
	}
	
	/*
	 * @RequestMapping("qnaUpdate") public String modified(QnABean qnaBean, Model
	 * model) { qnaService.qnaUpdate(qnaBean); return "redirect:qnaList"; }
	 */
	
	@RequestMapping("qnaDelete")
	public String delete(int qNo) {
		qnaService.qnaDelete(qNo);
		return "redirect:qnaList";
	}
	
	@RequestMapping(value="/image", method=RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile  file) {
		System.out.println("inputed file - : " + file);
		try {
			System.out.println("inputed file byte - : " + file.getBytes().toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            UploadFile uploadedFile = imageService.store(file);
            return ResponseEntity.ok().body("/image/" + uploadedFile.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
	
}
