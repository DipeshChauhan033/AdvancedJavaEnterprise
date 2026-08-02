package com.mainapp;

import java.util.Scanner;

public class Account {
	private int an;
	private String bankName;
	
	
	
	public Account() {

		// TODO Auto-generated constructor stub
	}

	
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Account [an=" + an + ", bankName=" + bankName + "]";
	}
	
}
