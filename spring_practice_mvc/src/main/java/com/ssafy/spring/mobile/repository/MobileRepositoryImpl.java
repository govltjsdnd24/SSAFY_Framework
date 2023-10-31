package com.ssafy.spring.mobile.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.mobile.model.MobileDto;

@Repository("MobileRepositoryImpl")
public class MobileRepositoryImpl implements MobileRepository {

	SqlSession session;
	
	@Autowired
	public MobileRepositoryImpl(SqlSession session) {
		this.session = session;
	}

	String ns="com.ssafy.spring.mobile.repository.MobileRepository.";
	
	@Override
	public int mobileRegister(MobileDto dto) {
		return session.insert(ns+"mobileRegister", dto);
	}

	@Override
	public List<MobileDto> mobileList() {
		return session.selectList(ns+"mobileList");
	}

	@Override
	public MobileDto mobileView(MobileDto dto) {
		return session.selectOne(ns+"mobileView",dto);
	}

	@Override
	public int mobileUpdate(MobileDto dto) {
		return session.update(ns+"mobileUpdate",dto);
	}

	@Override
	public int mobileDelete(MobileDto dto) {
		return session.delete(ns+"mobileDelete",dto);
	}

}
