package com.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.entity.Employee;


public class Crud {
	
		public static void insert() {
			Session session = connection();
			Transaction t = session.getTransaction();
			
			t.begin();
			for(int i = 1;i<=20;i++) {
				Employee employee = new Employee("Dishant"+i,"Ahmedabad",50000);
				session.save(employee);
			}
			
			t.commit();
			System.out.println("Inserted");
		}
		
		public List<Employee> read(int start) {
			Session session = connection();
			
			String sql = "select * from employee";
			
			NativeQuery<Employee> nativeQuery = session.createNativeQuery(sql, Employee.class);
			
			nativeQuery.setFirstResult(start);
			nativeQuery.setMaxResults(4);
			List<Employee> resultList = nativeQuery.getResultList();
			
			return resultList;
			
		}
		public static Session connection() {
			
			try {
				
				InputStream is = Crud.class.getClassLoader().getResourceAsStream("config.properties");
				
				Properties p = new Properties();
				p.load(is);
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
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

