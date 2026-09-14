package com.mainapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mainapp.config.MyConfiguration;


public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Crud c = ac.getBean(Crud.class);
		//c.insert(104, "Daksh", "Gandhinagar", 35000);
		//c.update(101, "Karan");
		//c.delete(103);
		
		
		//c.readAll();
		//c.readAllPoJoBased();
		c.readConditionBased(102);
	}

}
