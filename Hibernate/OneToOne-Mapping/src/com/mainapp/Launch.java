package com.mainapp;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.mainapp.entity.*;


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
		
		Account account = new Account(11, "Kuldeep", "ICIC", "A2Z55JD0");
		Employee employee = new Employee(101, "Kuldeep", "Ahmedabad", 50000, account);
		account.setEmployee(employee);
		
		session.save(employee);
		transaction.commit();
		
		System.out.println("Inserted");
	}
	
	
	private static void read(Session session) {
		Employee employee = session.get(Employee.class, 101);
		System.out.println(employee.getEid());
		System.out.println(employee.getEname());
		System.out.println(employee.getEaddress());
		System.out.println(employee.getEsalary());
	}
	
	private static void read2(Session session) {
		Account ac = session.get(Account.class, 11);
		System.out.println(ac.getEmployee().getEname());
		
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