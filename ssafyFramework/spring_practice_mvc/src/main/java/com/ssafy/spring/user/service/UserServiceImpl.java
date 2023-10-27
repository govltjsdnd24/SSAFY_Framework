package com.ssafy.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.spring.user.model.UserDto;
import com.ssafy.spring.user.repository.UserRepository;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	UserRepository repository;
	
	@Autowired
	public UserServiceImpl(@Qualifier("UserRepositoryImpl")UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public int userRegister(UserDto dto) {
		return repository.userRegister(dto);
	}


	@Override
	public UserDto login(UserDto dto) {
		return repository.login(dto);
	}

}
