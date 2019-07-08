package com.bit.samp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstJAPATestController {
	@Autowired
	private HelloDao helloDao;
	
	
	@RequestMapping("/list")
	public void list(Model model ) {
		model.addAttribute("hellos", helloDao.findAll());
		
	}
	
	@RequestMapping("/insert")
	public String insert(Hello hello ) {
		helloDao.save(hello);
		return "forward:/list";
	}
	
	@RequestMapping("/findId")
	public String findId(int id, Model model ) {
		model.addAttribute("find", helloDao.findById(id));
		
		return "forward:/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Hello hello ) {
		helloDao.deleteAll();
		
		return "forward:/list";
	}
	
}
