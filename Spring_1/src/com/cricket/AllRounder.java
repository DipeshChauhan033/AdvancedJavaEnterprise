package com.cricket;

import java.util.ArrayList;
import java.util.List;

public class AllRounder {
		List<String> l = new ArrayList<>();
		public AllRounder() {
			l.add("Hardik Pandya");
			l.add("Axar patel");
			l.add("Shivam Dube");
		}
		
		public void getAllRoundername() {
			System.out.println(l);
		}
		
		public void addNewAllRounder(String Aname) {
			l.add(Aname);
			System.out.println("Added new all rounder");
		}
	
}
