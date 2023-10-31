package edu.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.ssafy"})
public class MemberSpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberSpringBootMvcApplication.class, args);
	}

}
