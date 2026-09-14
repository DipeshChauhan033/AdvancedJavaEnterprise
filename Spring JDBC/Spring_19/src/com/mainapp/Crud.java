package com.mainapp;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class Crud {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(int eid,String ename,String eaddress,double esalary) {
		String sql = "insert into employee(eid,ename,eaddress,esalary) values (?,?,?,?)";
		int row = jdbcTemplate.update(sql,eid,ename,eaddress,esalary);
		System.out.println(row);
	}
	
	public void update(int eid,String ename) {
		String sql="update employee set ename=? where eid=?";
		int update = jdbcTemplate.update(sql,ename,eid);
		System.out.println("Record Updated Successfully..");
	}
	
	public void delete(int eid) {
		String sql="delete from employee where eid=?";
		int delete = jdbcTemplate.update(sql,eid);
		System.out.println("Record deleted successfully");
	}
	
	//First process to real all the data from database
	public void readAll() {
		String sql="select * from employee";
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql);
		//System.out.println(queryForList);
		for(Map<String, Object> data:queryForList) {
			for(Entry<String, Object> entry:data.entrySet()) {
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
			System.out.println();
		}
	}
	
	//second process to read all the data from database
	public void readAllPoJoBased() {
		String sql="select * from employee";
		List<Employee> list = jdbcTemplate.query(sql, new RowMapperImpl());
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
	
	public void readConditionBased(int eid) {
		String sql="select * from employee where eid=?";
		Employee data = jdbcTemplate.queryForObject(sql,new RowMapperImpl(),eid);
		System.out.println(data);
	}
}
