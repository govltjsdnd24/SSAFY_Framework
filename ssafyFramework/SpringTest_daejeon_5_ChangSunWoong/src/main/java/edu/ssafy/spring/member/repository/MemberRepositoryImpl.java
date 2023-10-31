package edu.ssafy.spring.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.spring.member.model.MemberDto;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {

	SqlSession session;
	
	@Autowired
	public MemberRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	String ns="edu.ssafy.spring.member.repository.MemberRepository.";

	@Override
	public int memberRegister(MemberDto dto) {
		return session.insert(ns+"memberRegister", dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return session.selectOne(ns+"login", dto);
	}

	@Override
	public int memberUpdate(MemberDto dto) {
		return session.update(ns+"memberUpdate", dto);
	}

	@Override
	public int memberDelete(MemberDto dto) {
		return session.delete(ns+"memberDelete", dto);
	}

}
