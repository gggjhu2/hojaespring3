package com.hojae.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hojae.spring.board.model.vo.Board;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		
		return "forward:index.jsp";
	}
	
	@RequestMapping("/flow/a.do")
	public String flowA() {
		logger.info("/flow/a.do 요청!");
		// /WEB-INF/views/flow/a.jsp
		return "flow/a";
	}
		
	@RequestMapping("/flow/b.do")
	public String flowB() {
		logger.info("/flow/b.do요청!!");
		return "flow/b";
	}
			
	@RequestMapping("/kkk/kkk.do")
	public String KKK() {
		logger.info("/kkk/kkk.do요청!!!");
		return "kkk/kkk";
	}
				
	@RequestMapping("/hello/world.do")
	 public String helloWorld() {
		logger.info("/hello/world.do요청!!!!");
		return "hello/world";
	}

	@RequestMapping("/ho/jae.do")
	public String hojae() {
		logger.info("/ho/jae.do요청!!!!!!");
		return "ho/jae";
	}
		@RequestMapping("/mybatis/mybatis.do")
		public String myhatis() {
			logger.info("/mybatis/mybatis.do요청!!!");
			return "mybatis/mybatis";
				
	}
	
					
		}



