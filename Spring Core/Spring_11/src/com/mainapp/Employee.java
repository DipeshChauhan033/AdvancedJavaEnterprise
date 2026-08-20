package com.mainapp;

import java.util.Map;

public class Employee {
	
	private int eid;
	private String ename;
	private Map<String,String> mapOfBooks;
	private Map<String,Manager> mngr;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Map<String, String> getMapOfBooks() {
		return mapOfBooks;
	}
	public void setMapOfBooks(Map<String, String> mapOfBooks) {
		this.mapOfBooks = mapOfBooks;
	}
	public Map<String, Manager> getMngr() {
		return mngr;
	}
	public void setMngr(Map<String, Manager> mngr) {
		this.mngr = mngr;
	}
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", mapOfBooks=" + mapOfBooks + ", mngr=" + mngr + "]";
	}

	

	
}

