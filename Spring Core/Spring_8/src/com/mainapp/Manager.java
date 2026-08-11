package com.mainapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Manager {
	private String url;
	private String countryCode;
	private int mid;
	
	public Manager() {
		System.out.println("Manager Bean Instantiation");
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
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "Manager [url=" + url + ", countryCode=" + countryCode + ", mid=" + mid + "]";
	}
	
	
}

