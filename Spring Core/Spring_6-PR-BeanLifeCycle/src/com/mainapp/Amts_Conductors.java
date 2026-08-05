package com.mainapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Scanner;

public class Amts_Conductors{
	
	private ConductorAuthentication conAuth;
	private String conName;
	private int conId;
	private int todayNo;
	Scanner sc = new Scanner(System.in);
	
	public void noForCheck(int todayNo) {
		this.todayNo=todayNo;
	}
	public void verify(String conName,int conId,ConductorAuthentication conAuth) {
		this.conName=conName;
		this.conId=conId;
		this.conAuth=conAuth;
	}
	@PostConstruct
	public void msg(){
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("----------------------------AMTS Conductor Dashboard-----------------------------");
	}
	
	
	@PreDestroy
	public void destroy(){
		System.out.println("AMTS Conductor Dashboard Close..");
		
	}
	
	public void todayNum() {
		if(conId!=0) {
			System.out.println("Enter y to know today's TicketNUmber: ");
			String t = sc.next();
			if(t.equalsIgnoreCase("y")) {
				System.out.println("Today Clicked Number is: "+todayNo);
			}
		}
		else{
			System.out.println("You dont have any access...");
		}
		
	}
	
	@Override
	public String toString() {
		if(conId!=0) {
			return "Welcome "+conName+".....";
			
		}else {
			return "Record Not Found";
		}
		
	}
	
	
}
