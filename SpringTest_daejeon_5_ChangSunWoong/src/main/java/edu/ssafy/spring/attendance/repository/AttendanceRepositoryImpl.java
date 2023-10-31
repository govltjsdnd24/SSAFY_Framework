package edu.ssafy.spring.attendance.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.spring.attendance.model.AttendanceDto;
import edu.ssafy.spring.member.model.MemberDto;

@Repository("AttendanceRepositoryImpl")
public class AttendanceRepositoryImpl implements AttendanceRepository {

	SqlSession session;
	
	@Autowired
	public AttendanceRepositoryImpl(SqlSession session) {
		this.session = session;
	}

	String ns="edu.ssafy.spring.attendance.repository.AttendanceRepository.";
	
	@Override
	public int attendanceRegister(AttendanceDto dto) {
		return session.insert(ns+"attendanceRegister", dto);
	}

	@Override
	public List<AttendanceDto> attendanceList() {
		return session.selectList(ns+"attendanceList");
	}
	
	@Override
	public List<AttendanceDto> attendanceList(Map<String, Integer> map) throws Exception {
		return null;
	}

	@Override
	public AttendanceDto attendanceView(AttendanceDto dto) {
		return session.selectOne(ns+"attendanceView",dto);
	}

	@Override
	public int attendanceUpdate(AttendanceDto dto) {
		//return session.update(ns+"attendanceUpdate",dto);
		return 0;
	}

	@Override
	public int attendanceDelete(AttendanceDto dto) {
		return session.delete(ns+"attendanceDelete",dto);
	}

	@Override
	public int attendanceDeletes(String[] ano) {
		int sum=0;
		for(String no: ano) {
			sum+=session.delete(ns+"attendanceDelete",no);
		}
		return sum;
	}

	@Override
	public int attendanceCount() {
		return 0;
		
	}

	@Override
	public List<AttendanceDto> attendanceListPart(MemberDto member) {
		return session.selectList(ns+"attendanceListPart",member);
	}



}
