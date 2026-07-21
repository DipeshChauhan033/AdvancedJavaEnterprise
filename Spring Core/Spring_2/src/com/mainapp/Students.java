package com.mainapp;


public class Students{
	
	static {
		System.out.println("std Bean Loading");
	}
	public Students() {
		System.out.println("std Bean Instantiated");
	}
	
	public void test() {
		System.out.println("std Tested...");
	}
}
