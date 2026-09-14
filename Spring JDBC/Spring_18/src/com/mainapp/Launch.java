package com.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Launch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Crud c = (Crud) ac.getBean("crud");
		//c.insert(104, "Daksh", "Gandhinagar", 35000);
		//c.update(101, "Karan");
		//c.delete(103);
		
		
		//c.readAll();
		//c.readAllPoJoBased();
		c.readConditionBased(101);
	}

}
