package com.mainapp;

import java.util.Properties;

public class Employee {
	
	private int eid;
	private String ename;
	private Properties properties;
	/* private Map<String,Manager> mngr; */
	
	
	public Employee(Properties properties) {
		
		this.properties = properties;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", properties=" + properties + "]";
	}
	
	

	
}

