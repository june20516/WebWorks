package com.bit.miniboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.miniboard.model.service.FreeBoardService;

@Controller
public class FreeBoardController {
	@Autowired
	FreeBoardService freeBoardService;
	
	
	@RequestMapping("allList")
	public String allList(Model model) {
		model.addAttribute("freeBoardAll", freeBoardService.getAllList());
		return "free/allList";
	}
}
