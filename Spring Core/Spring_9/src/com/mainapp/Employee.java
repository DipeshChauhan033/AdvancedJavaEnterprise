package com.mainapp;

import java.util.List;

public class Employee {
	
	private int eid;
	private String ename;
	private List<String> listOfBooks;
	private List<Manager1> mngr1;
	
	public Employee() {
		System.out.println("Employee Bean Instantiation");
	}

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

	public List<String> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<String> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
	

	public List<Manager1> getMngr1() {
		return mngr1;
	}

	public void setMngr1(List<Manager1> mngr1) {
		this.mngr1 = mngr1;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", listOfBooks=" + listOfBooks + ", mngr1=" + mngr1 + "]";
	}

	
}

