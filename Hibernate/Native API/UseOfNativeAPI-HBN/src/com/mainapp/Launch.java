package com.mainapp;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Launch {
	public static void main(String args[]) {
		
		try {
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
			//configuration.configure(); //If Pure XML Approach
			configuration.setProperties(p);
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			System.out.println(session);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
