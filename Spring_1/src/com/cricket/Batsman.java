package com.cricket;

import java.util.ArrayList;
import java.util.List;

public class Batsman {
	List<String> l = new ArrayList<>();
	public Batsman() {
		l.add("Hardik Pandya");
		l.add("Virat Kohli");
		l.add("Rohit Sharma");
	}
	
	public void getBatsmanName() {
		System.out.println(l);
	}
	public void addNewBatsman(String bname) {
		l.add(bname);
		System.out.println("Added new batsman");
	}
}
