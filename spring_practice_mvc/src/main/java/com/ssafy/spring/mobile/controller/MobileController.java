package com.ssafy.spring.mobile.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.spring.mobile.model.MobileDto;
import com.ssafy.spring.mobile.service.MobileService;


@Controller
@RequestMapping("/mobile")
public class MobileController {

	private MobileService service;

	@Autowired
	public MobileController(MobileService service) {
		this.service = service;
	}
	
	@GetMapping("/register")
	public ModelAndView loginPage() {
		ModelAndView mav=new ModelAndView();
		try {
			mav.setViewName("mobile/registMobile");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	} 
	
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute MobileDto dto, HttpSession session) {
		ModelAndView mav=new ModelAndView();
		System.out.println(dto.toString());
		try {
			int result=service.mobileRegister(dto);
			if(result>0)
				mav.setViewName("redirect:/mobile/list");
			else
				mav.setViewName("/registMobile");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView logout() {
		ModelAndView mav=new ModelAndView();
		try {
			List<MobileDto> list = service.mobileList();
			mav.addObject("list",list);
			mav.setViewName("mobile/listMobile");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	@GetMapping("/view")
	public ModelAndView view(@ModelAttribute MobileDto dto) {
		ModelAndView mav=new ModelAndView();
		try {
			MobileDto result= service.mobileView(dto);
			mav.addObject("mobileInfo", result);
			mav.setViewName("mobile/detailMobile");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute MobileDto dto) {
		ModelAndView mav=new ModelAndView();
		System.out.println("DELETE "+dto);
		try {
			service.mobileDelete(dto);
			mav.setViewName("redirect:/mobile/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	
}
