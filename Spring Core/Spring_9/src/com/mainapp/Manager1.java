package com.mainapp;

public class Manager1 {
	private int mngrId;
	private String mngrName;
	
	public Manager1(int mngrId,String mngrName) {
		this.mngrId = mngrId;
		this.mngrName=mngrName;
	}

	@Override
	public String toString() {
		return "Manager1 [mngrId=" + mngrId + ", mngrName=" + mngrName + "]";
	}
	
	
}
