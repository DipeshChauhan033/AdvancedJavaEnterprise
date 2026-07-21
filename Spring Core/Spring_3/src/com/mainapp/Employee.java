package com.mainapp;


public class Employee{
	
	private int test;
	static {
		System.out.println("EMP Bean Loading");
	}
	public Employee() {
		System.out.println("EMP Bean Instantiated");
	}
	
	public void test() {
		System.out.println("EMP Tested..."+test);
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
	
}
