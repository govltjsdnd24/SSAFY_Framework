package edu.ssafy.spring.attendance.service;
import java.util.List;
import java.util.Map;

import edu.ssafy.spring.attendance.model.AttendanceDto;
import edu.ssafy.spring.member.model.MemberDto;
import edu.ssafy.spring.util.PageNavigation;

public interface AttendanceService {
	public int attendanceRegister(AttendanceDto dto);
	public List<AttendanceDto> attendanceList();
	public List<AttendanceDto> attendanceList(Map<String, Integer> map) throws Exception;
	public AttendanceDto attendanceView(AttendanceDto dto);
	public int attendanceUpdate(AttendanceDto dto);
	public int attendanceDelete(AttendanceDto dto);
	public int attendanceDeletes(String[] article_no);
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws Exception;
	public List<AttendanceDto> attendanceListPart(MemberDto member);
	
}
