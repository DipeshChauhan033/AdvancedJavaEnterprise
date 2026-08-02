package com.mainapp;

import java.util.UUID;

public class ObjectFactory {
	
	private Account account;

	private ObjectFactory(Account account) {
		this.account=account;
	}
	
	public Employee getObject() {
		
		Employee employee = new Employee();
		employee.setId(UUID.randomUUID().toString());
		
		employee.setAccount(account);
		
		return employee;
	}
}
