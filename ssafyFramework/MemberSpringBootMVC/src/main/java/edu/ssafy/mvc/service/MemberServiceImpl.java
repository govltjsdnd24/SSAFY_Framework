package edu.ssafy.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.mvc.dto.MemberDto;
import edu.ssafy.mvc.repository.MemberRepository;
import edu.ssafy.mvc.util.PageNavigation;
import edu.ssafy.mvc.util.PagingUtil;


@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{
	
private MemberRepository repo;
	
	@Autowired
	public MemberServiceImpl(@Qualifier("MemberRepositoryMybatis") MemberRepository repo) {
		this.repo = repo;
	}

	@Override
	public int memberInsert(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
		return repo.memberInsert(dto);
	}

	@Override
	public List<MemberDto> memberList() throws Exception{
		// TODO Auto-generated method stub
		return repo.memberList();
	}

	@Override
	public MemberDto memberView(MemberDto dto) throws Exception{
		// TODO Auto-generated method stub
		return repo.memberView(dto);
	}

	@Override
	public int memberUpdate(MemberDto dto) throws Exception{
		// TODO Auto-generated method stub
		return repo.memberUpdate(dto);
	}

	@Override
	public boolean login(MemberDto dto) throws Exception {
		return repo.login(dto)==null?false:true;
	}

	@Override
	public boolean memberDeletes(String[] ids) throws Exception {
		MemberDto dto = new MemberDto();
		for (String id : ids) {
			dto.setId(id);
			repo.memberDelete(dto);
		}
		return true;
	}
	@Override
	public int memberDelete(MemberDto dto) throws Exception {
		// TODO Auto-generated method stub
		return repo.memberDelete(dto);
	}

	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws Exception {
		int naviSize = PagingUtil.naviSize;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalSize = repo.memberCnt();
		//pageNavigation.setTotalCount(totalSize);
		int totalPageSize = (totalSize - 1)/sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageSize);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public List<MemberDto> memberListPage(Map<String, Integer> map) throws Exception {
		// TODO Auto-generated method stub
		return repo.memberListPage(map);
	}
}
