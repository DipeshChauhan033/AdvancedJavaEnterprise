package com.mainapp;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.mainapp.entity.Employee;

public class Launch {
	public static void main(String args[]) {
		Session session = connection();
		if(session!=null) {
			
			//insert(session);
			//read(session);
			//update(session);
			//delete(session);
		}
	}
	private static void delete(Session session) {
		Transaction t = session.getTransaction();
		t.begin();
		
		String sql = "delete from employeedetails where id=:id";
		NativeQuery<Employee> nativeQuery = session.createNativeQuery(sql,Employee.class);
		nativeQuery.setParameter("id", 105);
		nativeQuery.executeUpdate();
		
		System.out.println("Deleted..");
		t.commit();
	}
	private static void update(Session session) {
		Transaction t = session.getTransaction();
		t.begin();
		
		String sql = "update employeedetails set salary=:salary where id=:id";
		NativeQuery<Employee> nativeQuery = session.createNativeQuery(sql,Employee.class);
		nativeQuery.setParameter("salary", 15000);
		nativeQuery.setParameter("id", 101);
		nativeQuery.executeUpdate();
		
		System.out.println("Updated..");
		t.commit();
	}
	private static void read(Session session) {
		int n = 1;
		String sql = "select * from employeedetails";
		NativeQuery<Object[]> nativeQuery = session.createNativeQuery(sql);

		List<Object[]> resultList = nativeQuery.getResultList();
		for(Object[] o:resultList) {
			System.out.println("----------------------------Employee:"+n+"----------------------------");
			System.out.println("Eid :"+o[0]);
			System.out.println("Ename :"+o[1]);
			System.out.println("Eaddress :"+o[2]);
			System.out.println("Esalary :"+o[3]);
			n++;
		}
	}
	private static void insert(Session session) {
		Transaction t = session.getTransaction();
		t.begin();
		String sql = "insert into employeedetails(id,name,address,salary) values(:id,:name,:address,:salary)";
		NativeQuery nativeQuery = session.createNativeQuery(sql);
		nativeQuery.setParameter("id", 104);
		nativeQuery.setParameter("name", "Akshay");
		nativeQuery.setParameter("address", "Mumbai");
		nativeQuery.setParameter("salary", 10500);
		
		nativeQuery.executeUpdate();
		System.out.println("Inserted..");
		t.commit();
	}
	private static Session connection() {
		
		try {
			
			InputStream is = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			
			Properties p = new Properties();
			p.load(is);
			
			Configuration configuration = new Configuration();
	
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