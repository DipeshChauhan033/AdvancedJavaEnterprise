package com.mainapp;

import java.util.Scanner;

public class Manager{
	
	static {
		System.out.println("Manager Bean Loading");
	}
	public Manager() {
		System.out.println("Manager Bean Instantiated");
	}
	
	public String permission() {
		System.out.println("MNGR Tested...");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Key: ");
		int key = sc.nextInt();
		
		if(key==1111) {
			return "GRANTED";
		}
		else {
			return "NOT GRANTED";
		}
	}
	
}
