package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="audience")
public class Audience implements Person{
	@Override
	public void doSomething() throws CallException {
		System.out.println("영화를 봅니다");
		if(Math.random()<0.5)
			throw new CallException();
	}
}
