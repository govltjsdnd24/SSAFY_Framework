package edu.ssafy.spring.member.model;

public class MemberDto {
	private String id,pw,position,usernumber,name,rname,rclass;

	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String id, String pw, String position, String usernumber, String name, String rname,
			String rclass) {
		super();
		this.id = id;
		this.pw = pw;
		this.position = position;
		this.usernumber = usernumber;
		this.name = name;
		this.rname = rname;
		this.rclass = rclass;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRclass() {
		return rclass;
	}

	public void setRclass(String rclass) {
		this.rclass = rclass;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", position=" + position + ", usernumber=" + usernumber
				+ ", name=" + name + ", rname=" + rname + ", rclass=" + rclass + "]";
	}
	
	
}
