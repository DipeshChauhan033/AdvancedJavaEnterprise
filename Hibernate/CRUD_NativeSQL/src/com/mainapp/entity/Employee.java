package com.mainapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employeedetails")
@NamedNativeQuery(name = "insert",query="insert into employeedetails(id,name,address,salary)values(?,?,?,?)")
@NamedNativeQuery(name = "read",query="select * from employeedetails")
@NamedNativeQuery(name = "update", query="update employeedetails set salary=? where id=?")
@NamedNativeQuery(name = "delete", query="delete from employeedetails where id=?")
public class Employee {
	
	@Id
	@Column(name = "id")
	private int eid;
	@Column(name = "name")
	private String ename;
	@Column(name = "address")
	private String eaddress;
	@Column(name = "salary")
	private double esalary;
	
	public Employee(){
		//For hibernate
	}
	
	public Employee(int eid,String ename,String eaddress,double esalary) {
		super();
		this.eid=eid;
		this.ename=ename;
		this.eaddress=eaddress;
		this.esalary=esalary;
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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", esalary=" + esalary + "]";
	}
	
	
}
