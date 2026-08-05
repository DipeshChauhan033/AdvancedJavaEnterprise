package com.mainapp;
import java.util.Random;

public class TodayNumber {
	private int num;
	Random r = new Random();
	public TodayNumber() {
		num = r.nextInt(10);
	}
	public int getNum() {
		return num;
	}
	
}
