package com.ssafy.spring.user.service;

import com.ssafy.spring.user.model.UserDto;

public interface UserService {
	public int userRegister(UserDto dto);
	public UserDto login(UserDto dto);
}
