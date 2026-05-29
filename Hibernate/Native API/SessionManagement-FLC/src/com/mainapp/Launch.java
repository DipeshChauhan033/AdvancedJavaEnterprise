package com.mainapp;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mainapp.entity.Employee;

public class Launch {
	public static void main(String args[]) {
		Session session = connection();
		if(session!=null) {

			read(session);
			
			
		}
	}


	

	private static void read(Session session) {
		
		
		Employee employee1 = session.get(Employee.class, 101);
		System.out.println(employee1);
		
		Employee employee2 = session.load(Employee.class, 102);
		System.out.println(employee2);
		
		
		//Data is already in FLC so hbn not write query again
		/*Employee employee3 = session.get(Employee.class, 101);
		System.out.println(employee3);
		
		Employee employee4 = session.load(Employee.class, 102);
		System.out.println(employee4);*/
		
		//session.clear(); //For all
		session.evict(employee1);  //For specific
		//Now FLC is clear so hbn write query for it..
		Employee employee3 = session.get(Employee.class, 101);
		System.out.println(employee3);
		
		
	}

	
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
			//configuration.configure(); //if use xml approach
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Employee.class);
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession(); //if not use FLC then use sessionFactory.OpenStatelessSession();
			
			return session;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
