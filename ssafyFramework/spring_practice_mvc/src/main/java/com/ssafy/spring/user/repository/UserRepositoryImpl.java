package com.ssafy.spring.user.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.spring.user.model.UserDto;

@Repository("UserRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

	SqlSession session;
	
	@Autowired
	public UserRepositoryImpl(SqlSession session) {
		super();
		this.session = session;
	}
	
	String ns="com.ssafy.spring.user.repository.UserRepository.";

	@Override
	public int userRegister(UserDto dto) {
		return session.insert(ns+"userRegister", dto);
	}

	@Override
	public UserDto login(UserDto dto) {
		return session.selectOne(ns+"login", dto);
	}

}
