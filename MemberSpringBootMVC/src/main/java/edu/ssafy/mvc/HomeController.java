package edu.ssafy.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("index");
//		logger.warn();
//		logger.trace(msg):
//		logger.debug(msg);
//		logger.error(marker);
		
		return "index";
	}
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public String hello(HttpServletRequest req, 
						HttpServletResponse res, 
						HttpSession session, 
						ModelAndView mv, 
						Model m, 
						Locale locale) {
		String name = req.getParameter("name");
		System.out.println(name);
		req.setAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping(value = "param",method=RequestMethod.GET)
	public String param() {
		return "form";
	}
}
