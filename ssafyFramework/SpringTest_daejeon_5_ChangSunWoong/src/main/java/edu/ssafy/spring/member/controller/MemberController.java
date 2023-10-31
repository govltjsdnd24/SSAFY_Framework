package edu.ssafy.spring.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.spring.member.model.MemberDto;
import edu.ssafy.spring.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private MemberService service;

	@Autowired
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session, HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		try {
			MemberDto dto= new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			System.out.println(dto);
			MemberDto memberInfo=service.login(dto);
			System.out.println(memberInfo);
			if(memberInfo!=null) {
				session.setAttribute("memberInfo", memberInfo);
				mav.setViewName("index");
			}
			else {
				request.setAttribute("msg", "로그인 실패");
				mav.setViewName("index");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav=new ModelAndView();
		try {
			session.removeAttribute("memberInfo");
			mav.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	} 
	
}
