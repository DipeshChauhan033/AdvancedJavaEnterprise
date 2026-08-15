package com.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Employee emp = (Employee)ac.getBean("employee");
		
		
		System.out.println(emp);
		System.out.println("Collection Type of Employee: "+emp.getSetOfBooks().getClass());
		System.out.println("Collection Type of Manager: "+emp.getMngr().getClass());
		ac.close();
		
		
	}

}
