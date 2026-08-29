package com.mainapp;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	public Employee() {
		System.out.println("Bean Instantiation");
	}
	
	public void test() {
		System.out.println("Bean Tested");
	}
}

