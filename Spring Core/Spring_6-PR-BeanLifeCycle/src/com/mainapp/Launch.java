package com.mainapp;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
	
		Amts_Conductors ac = (Amts_Conductors) cp.getBean("conductors");
		
		
		System.out.println(ac);
		ac.todayNum();
		cp.close();
	}
}