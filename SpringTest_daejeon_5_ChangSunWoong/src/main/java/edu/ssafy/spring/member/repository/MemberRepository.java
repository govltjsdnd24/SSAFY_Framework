package edu.ssafy.spring.member.repository;

import edu.ssafy.spring.member.model.MemberDto;

public interface MemberRepository {
	public int memberRegister(MemberDto dto);
	public MemberDto login(MemberDto dto);
	public int memberUpdate(MemberDto dto);
	public int memberDelete(MemberDto dto);
}
