package com.mainapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mainapp.config.MyConfiguration;

public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		//Employee emp = (Employee) ac.getBean("emp"); //if name is defined
		
		Employee emp1 = ac.getBean(Employee.class);  //when bean name is not given
		emp1.test();
		System.out.println(emp1);
		
		Employee emp2 = ac.getBean(Employee.class);  //when bean name is not given
		emp2.test();
		System.out.println(emp2);
		
		
		ac.close();
	}

}
