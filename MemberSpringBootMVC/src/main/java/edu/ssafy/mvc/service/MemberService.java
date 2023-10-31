package edu.ssafy.mvc.service;

import java.util.List;
import java.util.Map;

import edu.ssafy.mvc.dto.MemberDto;
import edu.ssafy.mvc.util.PageNavigation;

public interface MemberService {
	int memberInsert(MemberDto dto) throws Exception;
	List<MemberDto> memberList() throws Exception;
	List<MemberDto> memberListPage(Map<String,Integer> map) throws Exception;
	MemberDto memberView(MemberDto dto) throws Exception;
	int memberUpdate(MemberDto dto) throws Exception;
	boolean login(MemberDto dto) throws Exception;
	
	int memberDelete(MemberDto dto) throws Exception;
	boolean memberDeletes(String[] id)  throws Exception;
	PageNavigation makePageNavigation(int currentPage, int sizePerPage)  throws Exception;
	
}
