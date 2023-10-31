package edu.ssafy.spring.member.service;

import edu.ssafy.spring.member.model.MemberDto;

public interface MemberService {
	public MemberDto login(MemberDto dto);
	public int memberRegister(MemberDto dto);
	public int memberUpdate(MemberDto dto);
	public int memberDelete(MemberDto dto);
}
