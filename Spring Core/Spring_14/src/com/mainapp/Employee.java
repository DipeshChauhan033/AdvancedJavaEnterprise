package com.mainapp;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Component("emp") //With Name
//@Component //Without name
//@Lazy
//@Scope("prototype")
public class Employee {
	
	public Employee() {
		System.out.println("Bean Instantiation");
	}
	
	//@PostConstruct
	public void init() {
		System.out.println("Bean initialization");
	}
	
	public void test() {
		System.out.println("Bean Tested");
	}
	
	//@PreDestroy
	public void destroy() {
		System.out.println("Bean Destroy");
	}
	
}


@Component("intern")
@Lazy
class Intern{
	public Intern() {
		System.out.println("Intern Bean Instatiation");
	}
	
	public void test() {
		System.out.println("Intern Tested");
	}
}

