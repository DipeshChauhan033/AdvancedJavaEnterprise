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
			
			//insert(session);
			//read(session);
			update(session);
			
		}
	}
	
	private static void insert(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Car car = new Car("GUJ5799", "GUJ11");
		Company company = new Company(101, "Honda");
		Employee employee = new Employee(001, "Dipesh", car, company);
	
		session.save(employee);
		transaction.commit();
		
		System.out.println("Inserted");
	}
	
	private static void update(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee employee = session.get(Employee.class, 1);
		employee.setEname("Nikunj");
		
		session.update(employee);
		transaction.commit();
		System.out.println("Updated");
	}
	
	private static void read(Session session) {
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee);
	}
	
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
	
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Car.class);
			configuration.addAnnotatedClass(Company.class);
			
			
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