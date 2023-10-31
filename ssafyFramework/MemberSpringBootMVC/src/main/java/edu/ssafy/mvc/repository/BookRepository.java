package edu.ssafy.mvc.repository;

import java.util.List;
import java.util.Map;

import edu.ssafy.mvc.dto.BookDto;
import edu.ssafy.mvc.dto.MemberDto;
import edu.ssafy.mvc.util.PageNavigation;

public interface BookRepository {
	int bookRegister(BookDto dto) throws Exception;
	List<BookDto> bookList() throws Exception;
	List<BookDto> bookListPage(Map<String,Integer> map) throws Exception;
	BookDto bookView(BookDto dto) throws Exception;
	int bookUpdate(BookDto dto) throws Exception;
	int bookDelete(BookDto dto) throws Exception;
	
	int bookCnt()  throws Exception;
}
