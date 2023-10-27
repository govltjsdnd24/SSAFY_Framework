package com.ssafy.spring.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.spring.mobile.model.MobileDto;
import com.ssafy.spring.mobile.repository.MobileRepository;

@Service("MobileServiceImpl")
public class MobileServiceImpl implements MobileService {

	MobileRepository repository;
	
	@Autowired
	public MobileServiceImpl(MobileRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public int mobileRegister(MobileDto dto) {
		System.out.println(dto);
		return repository.mobileRegister(dto);
	}

	@Override
	public List<MobileDto> mobileList() {
		return repository.mobileList();
	}


	@Override
	public MobileDto mobileView(MobileDto dto) {
		return repository.mobileView(dto);
	}

	@Override
	public int mobileUpdate(MobileDto dto) {
		return repository.mobileUpdate(dto);
	}

	@Override
	public int mobileDelete(MobileDto dto) {
		return repository.mobileDelete(dto);
	}

}
