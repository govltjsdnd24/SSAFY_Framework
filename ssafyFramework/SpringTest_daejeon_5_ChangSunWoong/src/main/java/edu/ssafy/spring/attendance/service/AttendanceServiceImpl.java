package edu.ssafy.spring.attendance.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.spring.attendance.model.AttendanceDto;
import edu.ssafy.spring.attendance.repository.AttendanceRepository;
import edu.ssafy.spring.member.model.MemberDto;
import edu.ssafy.spring.util.PageNavigation;
import edu.ssafy.spring.util.PagingUtil;

@Service("AttendanceServiceImpl")
public class AttendanceServiceImpl implements AttendanceService {

	AttendanceRepository repository;
	
	@Autowired
	public AttendanceServiceImpl(AttendanceRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public int attendanceRegister(AttendanceDto dto) {
		System.out.println(dto);
		return repository.attendanceRegister(dto);
	}

	@Override
	public List<AttendanceDto> attendanceList() {
		return repository.attendanceList();
	}

	@Override
	public List<AttendanceDto> attendanceList(Map<String, Integer> map) throws Exception {
		return repository.attendanceList(map);
	}

	@Override
	public AttendanceDto attendanceView(AttendanceDto dto) {
		return repository.attendanceView(dto);
	}

	@Override
	public int attendanceUpdate(AttendanceDto dto) {
		return repository.attendanceUpdate(dto);
	}

	@Override
	public int attendanceDelete(AttendanceDto dto) {
		return repository.attendanceDelete(dto);
	}

	@Override
	public int attendanceDeletes(String[] article_no) {
		return repository.attendanceDeletes(article_no);
	}

	
	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws Exception {
		int naviSize = PagingUtil.naviSize;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalSize = repository.attendanceCount();
		//pageNavigation.setTotalCount(totalSize);
		int totalPageSize = (totalSize - 1)/sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageSize);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public List<AttendanceDto> attendanceListPart(MemberDto member) {
		return repository.attendanceListPart(member);
	}





}
