package com.ssafy.spring.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.spring.user.model.UserDto;
import com.ssafy.spring.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav=new ModelAndView();
		try {
			mav.setViewName("user/login");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	} 
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute UserDto dto, @RequestParam(name = "saveid", required = false) String saveid, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		try {
			UserDto userInfo=service.login(dto);
			if(userInfo!=null) {
				session.setAttribute("userInfo", userInfo);
				mav.setViewName("index");
				
				Cookie cookie = new Cookie("saveId", userInfo.getId());
				cookie.setPath("/user");
				if("remember".equals(saveid)) {
					cookie.setMaxAge(60*60*24*365*40);
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
			}
			else {
				request.setAttribute("msg", "로그인 실패");
				mav.setViewName("user/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav=new ModelAndView();
		try {
			session.removeAttribute("userInfo");
			mav.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	} 
	
}
