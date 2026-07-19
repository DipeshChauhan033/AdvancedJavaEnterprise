package com.mainapp;

class Intern{
	public Intern(){
		System.out.println("Intern Work Start..");
	}
}
public class Employee extends Intern{
	
	static {
		System.out.println("EMP Bean Loading");
	}
	public Employee() {
		System.out.println("EMP Bean Instantiated");
	}
	
	public void test() {
		System.out.println("Tested...");
	}
}
