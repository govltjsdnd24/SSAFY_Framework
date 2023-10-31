package com.ssafy.spring.mobile.repository;

import java.util.List;

import com.ssafy.spring.mobile.model.MobileDto;

public interface MobileRepository {
	public int mobileRegister(MobileDto dto);
	public List<MobileDto> mobileList();
	public MobileDto mobileView(MobileDto dto);
	public int mobileUpdate(MobileDto dto);
	public int mobileDelete(MobileDto dto);
}
