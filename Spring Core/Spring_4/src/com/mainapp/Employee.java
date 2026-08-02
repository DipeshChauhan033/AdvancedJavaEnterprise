package com.mainapp;


public class Employee{
	private String id;
	
	private Account account;
	
	
	public void setAccount(Account account) {
		this.account = account;
	}


	public Employee(String id) {
		super();
		System.out.println("EMP Bean Instantiated through Parameterized constructor..");
		this.id = id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public Employee() {
		System.out.println("EMP Bean Instantiated");
	}
	
	
	
	public void test() {
		System.out.println("EMP Tested...");
		System.out.println("Employee id: "+id);
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", account=" + account + "]";
	}
	
	
	
}
