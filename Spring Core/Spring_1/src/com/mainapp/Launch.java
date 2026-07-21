package com.mainapp;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cricket.*;

public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ClassPathResource classPathResource = new ClassPathResource("bean.xml");
//		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
//		
//		Employee emp = (Employee)xmlBeanFactory.getBean("emp");
//		emp.test();
		
		//----->Using ClassPathXmlApplicationContext
		
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//		Employee emp = (Employee) ac.getBean("emp");
//		emp.test();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("To show different types of player , enter batsman,bowler or allrounder :");
		
		String s = sc.nextLine().toLowerCase();
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		switch(s) {
			case "batsman":
				Batsman batsman = (Batsman) ac.getBean("batsmans");
				batsman.getBatsmanName();
				break;
				
			case "bowler":
				Bowler bowler = (Bowler) ac.getBean("bowlers");
				bowler.getBowlername();
				break;
				
			case "allrounder":
				AllRounder allrounder = (AllRounder) ac.getBean("allrounders");
				allrounder.getAllRoundername();
				break;
		}
	}

}
