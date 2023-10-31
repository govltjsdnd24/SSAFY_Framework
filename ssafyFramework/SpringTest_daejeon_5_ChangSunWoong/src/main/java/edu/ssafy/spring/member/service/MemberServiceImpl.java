package edu.ssafy.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.spring.member.model.MemberDto;
import edu.ssafy.spring.member.repository.MemberRepository;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
	
	MemberRepository repository;
	
	@Autowired
	public MemberServiceImpl(@Qualifier("MemberRepositoryImpl")MemberRepository repository) {
		this.repository = repository;
	}

	@Override
	public int memberRegister(MemberDto dto) {
		return repository.memberRegister(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return repository.login(dto);
	}

	@Override
	public int memberUpdate(MemberDto dto) {
		return repository.memberUpdate(dto);
	}

	@Override
	public int memberDelete(MemberDto dto) {
		return repository.memberDelete(dto);
	}

}
