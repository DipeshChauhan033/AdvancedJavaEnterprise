package com.mainapp;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mainapp.entity.Employee;

public class Launch {
	public static void main(String args[]) {
		Session session = connection();
		if(session!=null) {
			//insert(session);
			read(session);
			//update(session);
			//delete(session);
		}
	}

	private static void delete(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Employee employee = session.get(Employee.class, 104);
		if(employee!=null) {
			session.remove(employee);
			System.out.println("Data Deleted..");
		}
		
		transaction.commit();
	}

	private static void update(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Employee employee = session.get(Employee.class, 101);
		if(employee!=null) {
			employee.setEsalary(50000);
			session.update(employee);
			
			System.out.println("Data Updated..");
		}
		
		transaction.commit();
	}

	private static void read(Session session) {
		//both get() and load() method to ... Read the data 
		Employee employee = session.get(Employee.class, 101);
		System.out.println(employee);//return null, if data not exist in db
		
		Employee employee1 = session.load(Employee.class, 102);
		System.out.println(employee1); //throw exception, if data not exist in db
	}

	private static void insert(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Employee obj = new Employee(105,"Om Barad","Ahmedabad",60000);
		session.save(obj);
		
		
		transaction.commit();
		System.out.println("Data Inserted..");
	}
	
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
			//configuration.configure(); //if use hbm.xml approach
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Employee.class);
			
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
