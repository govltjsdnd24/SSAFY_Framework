package com.ssafy.spring.user.model;

public class UserDto {
	private String id,pw;

	public UserDto(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pw=" + pw + "]";
	}
	
	
}
