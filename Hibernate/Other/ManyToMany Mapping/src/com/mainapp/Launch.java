package com.mainapp;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mainapp.entity.Account;
import com.mainapp.entity.Employee;


public class Launch {
	public static void main(String args[]) {
		Session session = connection();
		if(session!=null) {
			System.out.println(session);
			//insert(session);
			//read(session);
			read2(session);
		}
	}
	
	private static void insert(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Account account1 = new Account(101, "Kuldeep", "Panjab National Bank", "25KIK564AD");
		Account account2 = new Account(102, "Kuldeep", "Panjab National Bank", "26KIK564AD");
		Account account3 = new Account(103, "Kuldeep", "Panjab National Bank", "27KIK564AD");
		
		List<Account> list = Arrays.asList(account1,account2,account3);
		
		Employee employee1 = new Employee(11,"Kuldeep soni","Mumbai",25000,list);
		Employee employee2 = new Employee(12,"Rajveer soni","Delhi",26000,list);
		
		List<Employee> employeelist = Arrays.asList(employee1,employee2);
		account1.setEmployee(employeelist);
		account2.setEmployee(employeelist);
		
		
		session.save(employee1);
		session.save(employee2);
		
		transaction.commit();
		
		System.out.println("Inserted");
	}
	
	
	private static void read(Session session) {
		Employee employee = session.get(Employee.class, 11);
		System.out.println(employee.getEid());
		System.out.println(employee.getEname());
		System.out.println(employee.getEaddress());
		System.out.println(employee.getEsalary());
		System.out.println();
		
		System.out.println("Account Details..");
		for(Account acc : employee.getAccount()) {
			System.out.println(acc.getAno());
			System.out.println(acc.getAhname());
			System.out.println(acc.getBname());
			System.out.println(acc.getIfsc());
			System.out.println();
		}
		
	}
	
	private static void read2(Session session) {
		Account account = session.get(Account.class, 102);
		System.out.println(account.getAno());
		System.out.println(account.getAhname());
		System.out.println(account.getBname());
		System.out.println(account.getIfsc());
		
		System.out.println("Employee details..");
		
		for(Employee e: account.getEmployee()) {
			System.out.println(e.getEid());
			System.out.println(e.getEname());
		}
	}
	
	
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
	
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Account.class);
			
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession(); 
			return session;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}