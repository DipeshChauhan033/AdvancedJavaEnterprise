package com.mainapp;

public class Students {
	private String url;
	private String countryCode;
	private int sid;

	public Students() {
		System.out.println("Student Bean Instantiation");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Students [url=" + url + ", countryCode=" + countryCode + ", sid=" + sid + "]";
	}
	
	

	
	
}

