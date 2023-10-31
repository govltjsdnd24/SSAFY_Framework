package edu.ssafy.mvc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.mvc.dto.MemberDto;
import edu.ssafy.mvc.repository.MemberRepository;
import edu.ssafy.mvc.util.PageNavigation;
import edu.ssafy.mvc.util.PagingUtil;

@Service("MemberServiceMapperImpl")
public class MemberServiceMapperImpl implements MemberService {

	SqlSession session;

	@Autowired
	public MemberServiceMapperImpl(SqlSession session) {
		this.session = session;
	}

	@Override
//	@Transactional
	public int memberInsert(MemberDto dto) throws Exception {
		return session.getMapper(MemberRepository.class).memberInsert(dto);
	}

	@Override
	public List<MemberDto> memberList() throws Exception {
		return session.getMapper(MemberRepository.class).memberList();
	}

	@Override
	public List<MemberDto> memberListPage(Map<String, Integer> map) throws Exception {
		return session.getMapper(MemberRepository.class).memberListPage(map);
	}

	@Override
	public MemberDto memberView(MemberDto dto) throws Exception {
		return session.getMapper(MemberRepository.class).memberView(dto);
	}

	@Override
	public int memberUpdate(MemberDto dto) throws Exception {
		return session.getMapper(MemberRepository.class).memberUpdate(dto);
	}

	@Override
	public boolean login(MemberDto dto) throws Exception {
		return session.getMapper(MemberRepository.class).login(dto)!=null?true:false;
	}

	@Override
	public int memberDelete(MemberDto dto) throws Exception {
		return session.getMapper(MemberRepository.class).memberDelete(dto);
	}

	@Override
	public boolean memberDeletes(String[] ids) throws Exception {
		boolean result=true;
		for(String id: ids) {
			MemberDto dto= new MemberDto();
			dto.setName(id);
			result=session.getMapper(MemberRepository.class).memberDelete(dto)>0 && result==true?true:false;
		}
		return result;
	}

	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws Exception {
		int naviSize = PagingUtil.naviSize;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalSize=memberCnt();
		int totalPageSize = (totalSize - 1)/sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageSize);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}
	
	public int memberCnt() {
		return session.selectOne("edu.ssafy.mvc.repository.MemberRepository.memberCnt");
	}

}
