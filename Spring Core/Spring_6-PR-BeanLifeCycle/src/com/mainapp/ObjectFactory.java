package com.mainapp;


import java.util.Scanner;

public class ObjectFactory {
	
	Scanner sc = new Scanner(System.in);
	private ConductorAuthentication conAuth;
	private TodayNumber n;
	Amts_Conductors ac = new Amts_Conductors();
	
	

	public ObjectFactory(ConductorAuthentication conAuth) {
		conAuth.checkValidation();
		this.conAuth=conAuth;
	}
	
	
	public void setN(TodayNumber n) {
		this.n = n;
	}



	private Amts_Conductors getObject() {
		if((conAuth.getConName().equalsIgnoreCase("ajay") && conAuth.getConid()==101)|| (conAuth.getConName().equalsIgnoreCase("rajan")&& conAuth.getConid()==102)|| (conAuth.getConName().equalsIgnoreCase("dipesh") && conAuth.getConid()==103)) {
			System.out.println("Authentication Successfully..");
			ac.verify(conAuth.getConName(), conAuth.getConid(), conAuth);
			ac.noForCheck(n.getNum());
		}
		else {
			System.out.println("Authentication Fail...");
		}
		
		
		return ac;
		
	}
	
	
	
}



