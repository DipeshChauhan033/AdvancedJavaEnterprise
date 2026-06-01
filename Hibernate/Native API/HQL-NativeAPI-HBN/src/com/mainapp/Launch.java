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
			//update(session);
			//delete(session);
			copy(session);
		}
	}
	private static void delete(Session session) {
		String hql = "delete from Employee where eid=:eid";
		Transaction t = session.getTransaction();
		t.begin();
	
		Query<?> query = session.createQuery(hql);
		query.setParameter("eid", 104);
		query.executeUpdate();
		
		t.commit();
		System.out.println("Deleted..");
	}
	private static void update(Session session) {
		
		String hql = "update Employee set esalary=:esalary where eid=:eid";
		Transaction t = session.getTransaction();
		t.begin();
		Query<?> query = session.createQuery(hql);
		query.setParameter("esalary", 155000.0);
		query.setParameter("eid", 101);
		query.executeUpdate();
		
		t.commit();
		System.out.println("Updated..");
		
	}
	private static void read(Session session) {
		
		Query<Employee> query = session.createNamedQuery("ReadAll",Employee.class);

		List<Employee> resultList = query.getResultList();
		System.out.println(resultList);
	}
	private static void copy(Session session) {
		String hql = "insert into Employee(eid,ename,eaddress,esalary) select eid,ename,eaddress,esalary from Employee2";
		Transaction t = session.getTransaction();
		t.begin();
		
		Query<?> query = session.createQuery(hql);
		query.executeUpdate();
		t.commit();
		System.out.println("Copied");
		
	}
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
	
			configuration.setProperties(p);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Employee2.class);
			
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