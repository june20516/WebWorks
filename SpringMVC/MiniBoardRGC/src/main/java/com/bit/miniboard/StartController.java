package com.bit.miniboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StartController {
	
	private static final Logger logger = LoggerFactory.getLogger(StartController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("naverTest")
	public String naverTest() {
		return "naverTest";
	}
	/**
	 * INFO : com.bit.miniboard.StartController - header : host
 header : connection
 header : content-length
 header : cache-control
 header : origin
 header : upgrade-insecure-requests
 header : content-type
 header : user-agent
 header : accept
 header : referer
 header : accept-encoding
 header : accept-language
 header : cookie
	 * @param request
	 * @return
	 */
	@RequestMapping(value="insertTest", method=RequestMethod.POST)
	public String insertTest(HttpServletRequest request) {
		
		logger.info("host : "+request.getHeader("host"));
		logger.info("connection : "+request.getHeader("connection"));
		logger.info("content-length : "+request.getHeader("content-length"));
		logger.info("cache-control : "+request.getHeader("cache-control"));
		logger.info("origin : "+request.getHeader("origin"));
		logger.info("upgrade-insecure-requests : "+request.getHeader("upgrade-insecure-requests"));
		logger.info("content-type : "+request.getHeader("content-type"));
		logger.info("user-agent : "+request.getHeader("user-agent"));
		logger.info("accept : "+request.getHeader("accept"));
		logger.info("referer : "+request.getHeader("referer"));
		logger.info("accept-encoding : "+request.getHeader("accept-encoding"));
		logger.info("accept-language : "+request.getHeader("accept-language"));
		logger.info("cookie : "+request.getHeader("cookie"));
		
//		MultipartRequest multipartRequest ;
		
		return "home";
	}
	
}
