package com.mainapp;


public class Employee{
	
	static {
		System.out.println("EMP Bean Loading");
	}
	public Employee() {
		System.out.println("EMP Bean Instantiated");
	}
	
	public void test() {
		System.out.println("EMP Tested...");
	}
}
