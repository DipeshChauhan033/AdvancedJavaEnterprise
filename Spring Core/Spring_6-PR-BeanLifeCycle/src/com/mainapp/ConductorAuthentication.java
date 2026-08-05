package com.mainapp;

import java.util.Scanner;

public class ConductorAuthentication {
	
	private String conName;
	private int conid;
	Scanner sc = new Scanner(System.in);
	
	public ConductorAuthentication() {
		
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public int getConid() {
		return conid;
	}

	public void setConid(int conid) {
		this.conid = conid;
	}

	public void checkValidation() {
		System.out.println("Enter your NAME for verification: ");
		conName = sc.nextLine();

		System.out.println("Enter your ID for verification: ");
		conid = sc.nextInt();
		
		
	}
	
}
