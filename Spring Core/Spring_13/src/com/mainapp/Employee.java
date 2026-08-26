package com.mainapp;

import java.util.List;
import java.util.Properties;

public class Employee {
	
	private int eid;
	private Manager mngr;
	private Car car;
	private List<String> listOfJobs;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Manager mngr, Car car, List<String> listOfJobs) {
		super();
		this.mngr = mngr;
		this.car = car;
		this.listOfJobs = listOfJobs;
	}
	
	public Manager getMngr() {
		return mngr;
	}
	public void setMngr(Manager mngr) {
		this.mngr = mngr;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public List<String> getListOfJobs() {
		return listOfJobs;
	}
	public void setListOfJobs(List<String> listOfJobs) {
		this.listOfJobs = listOfJobs;
	}
	

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", mngr=" + mngr + ", car=" + car + ", listOfJobs=" + listOfJobs + "]";
	}
	
	
}

