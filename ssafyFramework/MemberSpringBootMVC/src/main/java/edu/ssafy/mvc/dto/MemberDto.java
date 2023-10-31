package edu.ssafy.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
//기본생성자
@AllArgsConstructor
//모든 arg 있는 생성자
//@Data

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String age;
	private String addr;
	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPw() {
//		return pw;
//	}
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getAge() {
//		return age;
//	}
//	public void setAge(String age) {
//		this.age = age;
//	}
//	public String getAddr() {
//		return addr;
//	}
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//	public MemberDto(String id, String pw, String name, String age, String addr) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.age = age;
//		this.addr = addr;
//	}
//	@Override
//	public String toString() {
//		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
//	}
//	public MemberDto() {
//		super();
//	}
	
	
}
