package com.mainapp;

public class Employee {
	
	private String url;
	private String countryCode;
	private int eid;
	
	public Employee() {
		System.out.println("Employee Bean Instantiation");
	}
	
	public void setUrl(String url) {
		this.url=url;
	}

	public String getUrl() {
		return url;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "Employee [url=" + url + ", countryCode=" + countryCode + ", eid=" + eid + "]";
	}
	
	
	
}

