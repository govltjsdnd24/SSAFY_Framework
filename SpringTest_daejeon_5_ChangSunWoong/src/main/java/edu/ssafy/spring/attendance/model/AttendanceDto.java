package edu.ssafy.spring.attendance.model;

public class AttendanceDto {
	private String ano, usernumber, issuedate, issue;
	private String name,rname,rclass;

	public AttendanceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceDto(String ano, String usernumber, String issuedate, String issue, String name, String rname,
			String rclass) {
		super();
		this.ano = ano;
		this.usernumber = usernumber;
		this.issuedate = issuedate;
		this.issue = issue;
		this.name = name;
		this.rname = rname;
		this.rclass = rclass;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
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
		return "AttendanceDto [ano=" + ano + ", usernumber=" + usernumber + ", issuedate=" + issuedate + ", issue="
				+ issue + ", name=" + name + ", rname=" + rname + ", rclass=" + rclass + "]";
	}

	
	


	
}
