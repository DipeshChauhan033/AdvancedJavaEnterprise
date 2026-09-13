package com.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Crud c = (Crud) ac.getBean("crud");
		c.insert(101, "Dipesh", "New Ranip", 35000);
	}

}
