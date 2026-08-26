package com.mainapp;

public class Manager {
	private int mngrId;
	private String mngrName;
	
	static {
		System.out.println("Values Initialization");
	}
	
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int mngrId,String mngrName) {
		this.mngrId = mngrId;
		this.mngrName=mngrName;
	}
	
	public void test() {
		System.out.println();
	}
	
	
	
	public int getMngrId() {
		return mngrId;
	}

	public void setMngrId(int mngrId) {
		this.mngrId = mngrId;
	}

	public String getMngrName() {
		return mngrName;
	}

	public void setMngrName(String mngrName) {
		this.mngrName = mngrName;
	}

	@Override
	public String toString() {
		return "Manager [mngrId=" + mngrId + ", mngrName=" + mngrName + "]";
	}

	
	
	
}
