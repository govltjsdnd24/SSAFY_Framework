package edu.ssafy.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.mvc.dto.MemberDto;
import springfox.documentation.annotations.ApiIgnore;

//@Controller
@RestController
@RequestMapping("/cors")
@CrossOrigin("*")
@ApiIgnore
public class CorsRestController {
	
	@GetMapping("/test01")
	public void test01(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id= request.getParameter("id");
		String name =request.getParameter("name");
		System.out.println(id+","+name);
		
		response.setContentType("text/plain; charset=utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		writer.write(id+"("+name+")님 반갑습니다.");
		writer.close();
	}
	
	@GetMapping("/test02")
	public @ResponseBody String test02(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id= request.getParameter("id");
		String name =request.getParameter("name");
		System.out.println(id+","+name);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return id+"("+name+")님 반갑습니다.";
	}
	
	@GetMapping("/test03")
	public @ResponseBody ResponseEntity<String> test03(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id= request.getParameter("id");
		String name =request.getParameter("name");
		System.out.println(id+","+name);
		
//		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return new ResponseEntity<String>(id+"("+name+")님 반갑습니다.", HttpStatus.OK);
		
	}
	
	@GetMapping("/test04")
	public ResponseEntity<String> test04(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id= request.getParameter("id");
		String name =request.getParameter("name");
		System.out.println(id+","+name);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return new ResponseEntity<String>(id+"("+name+")님 반갑습니다.", HttpStatus.OK);
	}
	
	@GetMapping("/test05")
	public ResponseEntity<MemberDto> test05(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id= request.getParameter("id");
		String name =request.getParameter("name");
		System.out.println(id+","+name);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAge("21");
		dto.setId(id);
		dto.setPw("22");
		dto.setAddr("대전");
		return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/test06")
	public ResponseEntity<MemberDto> test06(@RequestBody MemberDto dto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(dto);
		dto.setAddr("999");
		
		return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
	}
}
