package com.example.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.example.demo.dao.MemberMapper;
import com.example.demo.vo.Member;


@Controller
public class TestController {
		
	@Autowired
	private MemberMapper memberMapper;
	//멤버 목록 불러와서 html에서 보여주기
	
	@Autowired
	private CookieLocaleResolver localeResolver;
	
	@RequestMapping("/all")
	public String memberAllList(Model model) {
		model.addAttribute("members", memberMapper.selectAll());
	return "memberAllList"; //memberAllList.html
		
	}

	@RequestMapping("/all/{locale}")
	public String localeMemberAllList(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String locale) {
		Locale a = new Locale(locale.substring(0,2),locale.substring(3));
		localeResolver.setLocale(request, response, a);
		model.addAttribute("members", memberMapper.selectAll());
		return "memberAllList"; //memberAllList.html
		
	}
	
	//멤버의 id를 가지고 검색을 해서 보여주기
	@GetMapping("/memSearch")
	public String memberInfo(String id, Model model){
		Member member = memberMapper.memberSearch(id);
		
		
		model.addAttribute("member", member);
		return "memberInfo";
	}
	
	@GetMapping("/memIdSearch/{id}")
	public String memberIdSearch(@PathVariable String id, Model model){
		Member member = memberMapper.memberSearch(id);
		model.addAttribute("member", member);
		return "memberInfo";
	}
	
}
