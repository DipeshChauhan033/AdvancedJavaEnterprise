package com.mainapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account{
	
	@Id
	private int ano;
	private String ahname;
	private String bname;
	private String ifsc;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eid")
	private Employee employee;
	public Account() {
		
	}
	
	

	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Account(int ano, String ahname, String bname, String ifsc) {
		super();
		this.ano = ano;
		this.ahname = ahname;
		this.bname = bname;
		this.ifsc = ifsc;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAhname() {
		return ahname;
	}

	public void setAhname(String ahname) {
		this.ahname = ahname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	
	
	
	
}
