package com.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Employee emp = (Employee)ac.getBean("employee");
		System.out.println(emp);
		
		Employee2 emp2 = (Employee2)ac.getBean("employee2");
		System.out.println(emp2);
		
		
		ac.close();
		
		
	}

}
