package com.mainapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee{
	
	@Id
	private int eid;
	private String ename;
	private String eaddress;
	private double esalary;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EmployeeAcc",joinColumns = @JoinColumn(name = "eid"),inverseJoinColumns = @JoinColumn(name = "aid"))
	
	private List<Account> account;
	
	public Employee() {
		
	}

	public Employee(int eid, String ename, String eaddress, double esalary, List<Account> account) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.esalary = esalary;
		this.account = account;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	
	

	
}
