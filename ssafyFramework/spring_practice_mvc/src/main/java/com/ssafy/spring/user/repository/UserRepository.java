package com.ssafy.spring.user.repository;

import com.ssafy.spring.user.model.UserDto;

public interface UserRepository {
	public int userRegister(UserDto dto);
	public UserDto login(UserDto dto);
}
