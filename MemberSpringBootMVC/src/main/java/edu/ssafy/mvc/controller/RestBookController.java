package edu.ssafy.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.mvc.dto.BookDto;
import edu.ssafy.mvc.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@Api(tags = {"북 컨트롤러  API V1"})
@RequestMapping("/restbook")
public class RestBookController {
	
	private BookService service;
	@Autowired
	public RestBookController(@Qualifier("BookServiceImpl") BookService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> BookRegister(@RequestBody BookDto dto) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			int res = service.bookRegister(dto);
			map.put("resmsg", "입력성공");
			map.put("resdata", res);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "입력실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String,Object>> res = new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
		return res;
	};
	
	@GetMapping("/list")
	@ResponseBody
	@ApiOperation(value = "도서목록", notes = "책의 <big>전체 목록</big>을 반환해 줍니다.")
	public ResponseEntity<Map<String, Object>> BookList() {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<BookDto> list = service.bookList();
			map.put("resmsg", "조회성공");
			map.put("resdata", list);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "조회실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
	@GetMapping("/view/{isbn}")
	public ResponseEntity<Map<String, Object>> BookView(@PathVariable("isbn") String isbn) {
		BookDto dto = new BookDto();
		dto.setIsbn(isbn);
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			BookDto book = service.bookView(dto);
			map.put("resdata", book);
			map.put("resmsg", "조회성공");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "조회실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> BookUpdate(@RequestBody BookDto dto) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			int res = service.bookUpdate(dto);
			map.put("resdata", res);
			map.put("resmsg", "수정성공");
			
		} catch (Exception e) {
			map.put("resmsg", "수정실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
	@DeleteMapping("/delete/{isbn}")
	public ResponseEntity<Map<String, Object>> BookDelete(@PathVariable("isbn")String isbn) {
		Map<String,Object> map = new HashMap<String, Object>();
		BookDto dto = new BookDto();
		dto.setIsbn(isbn);
		try {
			int res = service.bookDelete(dto);
			map.put("resdata", res);
			map.put("resmsg", "삭제성공");
			
		} catch (Exception e) {
			map.put("resmsg", "수정실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
	@DeleteMapping("/deletes/{isbn}")
	public ResponseEntity<Map<String, Object>> BookDeletes(@PathVariable("isbn") String isbn )  {
		String[] isbns = isbn.split(",");
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			boolean res = service.bookDeletes(isbns);
			map.put("resdata", res);
			map.put("resmsg", "삭제성공");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("resmsg", "삭제실패");
			map.put("resdata", e.getMessage());
		}
		ResponseEntity<Map<String, Object>> res = new ResponseEntity<>(map,HttpStatus.OK);
		return res;
	};
	
	
}
