package com.mainapp;

import java.util.Set;

public class Employee {
	
	private int eid;
	private String ename;
	private Set<String> setOfBooks;
	private Set<Manager> mngr;
	
	

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



	public Set<String> getSetOfBooks() {
		return setOfBooks;
	}



	public void setSetOfBooks(Set<String> setOfBooks) {
		this.setOfBooks = setOfBooks;
	}



	public Set<Manager> getMngr() {
		return mngr;
	}



	public void setMngr(Set<Manager> mngr) {
		this.mngr = mngr;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", listOfBooks=" + setOfBooks + ", mngr1=" + mngr + "]";
	}

	
}

