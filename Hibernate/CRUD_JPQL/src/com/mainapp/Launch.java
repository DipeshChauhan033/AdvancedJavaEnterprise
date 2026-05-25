package com.mainapp;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Parameter;
import javax.persistence.Query;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.mainapp.entity.Employee;


public class Launch {
	public static void main(String args[]) {
		
		
		EntityManager em = connection();
		//insert(em);
		//read(em);
		//update(em);
		delete(em);
	}

	private static void insert(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		int n = 1;
		while(n<3) {
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter employee id:");
			int eid = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter employee name: ");
			String ename = sc.nextLine();
			
			System.out.println("Enter employee address");
			String eaddress = sc.nextLine();
			
			System.out.println("Enter employee salary");
			double esalary = sc.nextDouble();
			
			System.out.println();
			
			Employee obj = new Employee(eid,ename,eaddress,esalary);
			em.persist(obj);
			
			n++;
		}
		
		et.commit();
		System.out.print("Data Inserted");
	}
	
	private static void read(EntityManager em) {
		String sql = "select e from Employee e";
		Query query = em.createQuery(sql,Employee.class);
		List<Employee> list = query.getResultList();
		
		for(Employee e:list) {
			System.out.println(e);
		}
		
	}
	
	private static void update(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		String sql = "update Employee set esalary=:esalary where eid>:eid";
		Query query = em.createQuery(sql);
		query.setParameter("eid", 103);
		query.setParameter("esalary", 35000.0);
		
		query.executeUpdate();
		et.commit();
		
		System.out.println("Updated..");
	}
	
	private static void delete(EntityManager em) {
		
		Scanner sc = new Scanner(System.in);
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		String sql = "delete from Employee where eid=:eid";
		Query query = em.createQuery(sql);
		
		System.out.println("Enter eid to delete details: ");
		int eid = sc.nextInt();
		query.setParameter("eid", eid);
		
		query.executeUpdate();
		
		et.commit();
		System.out.println("Deleted..");
		
	}
	
	private static EntityManager connection() {
		EntityManager entityManager = null;
		
		try {
			InputStream inputStream = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			
			Map<String, String> map = new HashMap<String,String>();
			Set<String> data = properties.stringPropertyNames();
			
			for(String key:data) {
				map.put(key, properties.getProperty(key));
			}
			
			HibernatePersistenceProvider hpp = new HibernatePersistenceProvider();
			EntityManagerFactory entityManagerFactory = hpp.createContainerEntityManagerFactory(new PersistenceUnitInfoImpl(), map);
			entityManager = entityManagerFactory.createEntityManager();		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return entityManager;
	}
	
}
