package com.ssafy.spring.mobile.model;

public class MobileDto {
	private String mobileCode, model, company;
	String price;

	public MobileDto(String mobileCode, String model, String price, String company) {
		super();
		this.mobileCode = mobileCode;
		this.model = model;
		this.price = price;
		this.company = company;
	}

	public String getMobileCode() {
		return mobileCode;
	}

	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "MobileDto [mobileCode=" + mobileCode + ", model=" + model + ", price=" + price + ", company=" + company
				+ "]";
	}
	
	
}
