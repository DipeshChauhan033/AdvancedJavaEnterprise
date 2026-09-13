package com.mainapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



public class Crud {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(int eid,String ename,String eaddress,double esalary) {
		String sql = "insert into employee(eid,ename,eaddress,esalary) values (?,?,?,?)";
		int row = jdbcTemplate.update(sql,eid,ename,eaddress,esalary);
		System.out.println(row);
	}
}
