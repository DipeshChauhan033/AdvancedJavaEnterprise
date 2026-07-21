package com.cricket;

import java.util.ArrayList;
import java.util.List;

public class Bowler {
	List<String> l = new ArrayList<>();
	public Bowler() {
		l.add("Hardik Pandya");
		l.add("Jasprit Bumrah");
		l.add("Uzi Chahal");
	}
	
	public void getBowlername() {
		System.out.println(l);
	}
	public void addNewBowler(String bname) {
		l.add(bname);
		System.out.println("Added new bowler");
	}
}
