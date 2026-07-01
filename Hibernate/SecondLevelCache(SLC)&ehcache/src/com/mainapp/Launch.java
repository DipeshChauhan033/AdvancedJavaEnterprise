package com.mainapp;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mainapp.entity.Employee;


public class Launch {
	public static void main(String args[]) {
		SessionFactory sf = connection();
		if(sf!=null) {
		
			insert(sf);
			read(sf);
			read2(sf);
			
		}
	}
	
	private static void insert(SessionFactory sf) {
		Session session = sf.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
	
		Employee employee1 = new Employee(11,"Kuldeep soni","Mumbai",25000);
		
		session.save(employee1);
		
		transaction.commit();
		
		System.out.println("Inserted");
	}
	
	
	private static void read(SessionFactory sf) {
		Session session = sf.openSession();
		Employee employee = session.get(Employee.class,11);
		System.out.println(employee);
		
	}
	
	private static void read2(SessionFactory sf) {
		Session session = sf.openSession();
		Employee employee = session.get(Employee.class, 11);
		System.out.println(employee);
	}
	
	
	private static SessionFactory connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
	
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Employee.class);
			
			
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}