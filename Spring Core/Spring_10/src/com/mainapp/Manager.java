package com.mainapp;

public class Manager {
	private int mngrId;
	private String mngrName;
	
	static {
		System.out.println("Values Initialization");
	}
	public Manager(int mngrId,String mngrName) {
		this.mngrId = mngrId;
		this.mngrName=mngrName;
	}
	
	public void test() {
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Manager1 [mngrId=" + mngrId + ", mngrName=" + mngrName + "]";
	}
	
	
}
