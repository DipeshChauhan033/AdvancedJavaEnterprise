package com.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Manager mng = (Manager) ac.getBean("manager");
		String permission = mng.permission();
		
		if(permission.equals("GRANTED")) {
			Employee emp = (Employee) ac.getBean("emp");
			Students std = (Students) ac.getBean("students");
			
			emp.test();
			std.test();
		}
		else {
			System.out.println("Your are not authorized person to access employee and students");
		}
		
	}

}
