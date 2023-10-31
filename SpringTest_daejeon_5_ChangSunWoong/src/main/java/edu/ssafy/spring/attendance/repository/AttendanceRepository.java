package edu.ssafy.spring.attendance.repository;

import java.util.List;
import java.util.Map;

import edu.ssafy.spring.attendance.model.AttendanceDto;
import edu.ssafy.spring.member.model.MemberDto;

public interface AttendanceRepository {
	public int attendanceRegister(AttendanceDto dto);
	public List<AttendanceDto> attendanceList();
	public List<AttendanceDto> attendanceList(Map<String, Integer> map) throws Exception;
	public AttendanceDto attendanceView(AttendanceDto dto);
	public int attendanceUpdate(AttendanceDto dto);
	public int attendanceDelete(AttendanceDto dto);
	public int attendanceDeletes(String[] article_no);
	public int attendanceCount();
	public List<AttendanceDto> attendanceListPart(MemberDto member);
	
	
}
