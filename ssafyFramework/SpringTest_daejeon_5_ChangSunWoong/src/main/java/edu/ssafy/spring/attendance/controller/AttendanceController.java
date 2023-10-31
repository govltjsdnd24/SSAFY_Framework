package edu.ssafy.spring.attendance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.spring.attendance.model.AttendanceDto;
import edu.ssafy.spring.attendance.service.AttendanceService;
import edu.ssafy.spring.member.model.MemberDto;
import edu.ssafy.spring.util.PageNavigation;
import edu.ssafy.spring.util.PagingUtil;


@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	private AttendanceService service;

	@Autowired
	public AttendanceController(AttendanceService service) {
		this.service = service;
	}
	
//	@GetMapping("/subjectcheck/{subject}")
//	public @ResponseBody Map<String, String> idCheck(@PathVariable("subject") String subject) throws Exception{
//		AttendanceDto dto = new AttendanceDto();
//		dto.setSubject(subject);
//		AttendanceDto attendance = service.attendanceView(dto);
//		Map<String, String> map = new HashMap<String,String>();
//		System.out.println(attendance);
//		map.put("result", attendance==null?"사용하실 수 있는 제목입니다":"사용하실 수 없는 제목입니다");
//		return map;
//	}
	
	@GetMapping("/register")
	public ModelAndView loginPage() {
		ModelAndView mav=new ModelAndView();
		try {
			mav.setViewName("regist");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	} 
	
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute AttendanceDto dto, HttpSession session) {
		ModelAndView mav=new ModelAndView();
		MemberDto member=(MemberDto)session.getAttribute("memberInfo");
//		dto.setUser_id(member.getUser_id());
		try {
			int result=service.attendanceRegister(dto);
			if(result>0)
				mav.setViewName("redirect:/attendance/list");
			else
				mav.setViewName("/registAttendance");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView list(HttpSession session) {
		ModelAndView mav=new ModelAndView();
		MemberDto member=(MemberDto)session.getAttribute("memberInfo");
		try {
			List<AttendanceDto> list;
			if(member==null)
				list=service.attendanceListPart(member);
			else if(member.getPosition().equals("관리자"))
				list = service.attendanceList();
			else {
				System.out.println("관리자 아님");
				list=service.attendanceListPart(member);
			}
			mav.addObject("list",list);
			mav.setViewName("list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@GetMapping("/view")
	public ModelAndView view(@ModelAttribute AttendanceDto dto) {
		ModelAndView mav=new ModelAndView();
		try {
			AttendanceDto result= service.attendanceView(dto);
			System.out.println(result);
			mav.addObject("attendanceInfo", result);
			mav.setViewName("detail");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute AttendanceDto dto) {
		ModelAndView mav=new ModelAndView();
		System.out.println("DELETE "+dto);
		try {
			service.attendanceDelete(dto);
			mav.setViewName("redirect:/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@PostMapping("/deletes")
	public ModelAndView BookDeletes(String[] ano , ModelAndView mav)  {
		try {
			service.attendanceDeletes(ano);
			System.out.println("here");
			mav.setViewName("redirect:/attendance/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	};
}
