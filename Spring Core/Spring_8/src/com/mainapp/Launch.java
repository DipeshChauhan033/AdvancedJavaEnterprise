package com.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Employee emp = (Employee)ac.getBean("employee");
		Manager mng = (Manager)ac.getBean("manager");
		Students std = (Students)ac.getBean("students");
		System.out.println(emp);
		System.out.println(mng);
		System.out.println(std);
		ac.close();
		
	}

}
