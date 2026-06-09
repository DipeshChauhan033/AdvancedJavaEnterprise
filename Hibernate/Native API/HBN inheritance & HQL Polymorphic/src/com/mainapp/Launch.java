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
			
			Cricketer cricketer = new Cricketer(101,"Hardik pandaya",6000,"ALL");
			Footballer footballer = new Footballer(102,"Sunil",500,"GK");
			
			Transaction transaction = session.getTransaction();
			transaction.begin();
			
			session.save(cricketer);
			session.save(footballer);

			transaction.commit();
			
			System.out.println("Created And Inserted");
		}
	}
	
	private static void read(Session session) {
		
		
	}
	
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
	
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Player.class);
			configuration.addAnnotatedClass(Footballer.class);
			configuration.addAnnotatedClass(Cricketer.class);
			
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