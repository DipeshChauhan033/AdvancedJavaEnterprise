package com.mainapp.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Employee{
	
	@Id
	private int eid;
	private String ename;
	
	@Version
	private int updateCount;
	@Embedded
	private Car car;
	@Embedded
	private Company company;
	
	public Employee() {
		
	}

	public Employee(int eid, String ename, Car car, Company company) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.car = car;
		this.company = company;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", car=" + car + ", company=" + company + "]";
	}
	
	
	
}
