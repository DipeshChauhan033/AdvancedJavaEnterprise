package com.mainapp.entity;

import javax.persistence.Entity;

@Entity
public class Cricketer extends Player{
	private int run;
	private String ctype;
	
	public Cricketer() {
		
	}

	public Cricketer(int id, String name, int run, String ctype) {
		super(id, name);
		this.run = run;
		this.ctype = ctype;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	@Override
	public String toString() {
		return "Cricketer [run=" + run + ", ctype=" + ctype + "]";
	}
	
	
}
