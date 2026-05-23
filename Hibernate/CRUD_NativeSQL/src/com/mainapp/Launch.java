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
		//delete(em);
	}

	private static void insert(EntityManager em) {
		Scanner sc = new Scanner(System.in);
		//Insert-1 Method
		/*
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			String sql = "insert into employeedetails(id,name,address,salary)values(?,?,?,?)";
			
			int n = 0;
			while(n<2){
				Query query = em.createNativeQuery(sql);
				
				System.out.println("Enter employee id: ");
				int eid = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter employee name: ");
				String ename = sc.nextLine();
				
				System.out.println("Enter employee address: ");
				String eaddress = sc.nextLine();
				
				System.out.println("Enter employee salary: ");
				double esalary = sc.nextDouble();
				
				query.setParameter(1, eid);
				query.setParameter(2, ename);
				query.setParameter(3, eaddress);
				query.setParameter(4, esalary);
				
				query.executeUpdate();	
				System.out.println("Data inserted..");
				System.out.println();
				
				n++;
			}
			
			transaction.commit();
		}
		catch(Exception e) {
			System.out.println("Invalid entry..");
		}
		*/
		
		//Insert- method2 Using annotation
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			System.out.println("Bulk Store 5 DataSet...");
			int n = 0;
			while(n<5){
				Query query = em.createNamedQuery("insert"); //Annotation name based on employee class
				
				System.out.println("Enter employee id: ");
				int eid = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter employee name: ");
				String ename = sc.nextLine();
				
				System.out.println("Enter employee address: ");
				String eaddress = sc.nextLine();
				
				System.out.println("Enter employee salary: ");
				double esalary = sc.nextDouble();
				
				query.setParameter(1, eid);
				query.setParameter(2, ename);
				query.setParameter(3, eaddress);
				query.setParameter(4, esalary);
				
				query.executeUpdate();	
				System.out.println("Data inserted..");
				System.out.println();
				
				n++;
			}
			
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
	}
	
	private static void read(EntityManager em) {
		
		Query query = em.createNamedQuery("read");
		List<Object[]> resultList = query.getResultList();
		
		int n = 1;
		for(Object[] orr : resultList) {
			System.out.println("----------------------------Employee:"+n+"----------------------------");
			System.out.println("Eid: "+orr[0]);
			System.out.println("Ename: "+orr[2]);
			System.out.println("Eaddress: "+orr[1]);
			System.out.println("Esalary: "+orr[3]);
			System.out.println();
			n++;
		}	
	}
	
	private static void update(EntityManager em) {
		
		Scanner sc = new Scanner(System.in);
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Query query = em.createNamedQuery("update");
		System.out.println("Enter emloyee id to change its salary: ");
		int eid = sc.nextInt();
		
		System.out.println("Enter new salary: ");
		double esalary = sc.nextDouble();
		
		query.setParameter(1, esalary);
		query.setParameter(2, eid);
		
		query.executeUpdate();
		System.out.println("Salary Updated..");
		
		et.commit();
	}
	
	private static void delete(EntityManager em) {
		
		Scanner sc = new Scanner(System.in);
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Query query = em.createNamedQuery("delete");
		
		System.out.println("Enter employee id to delete those record: ");
		int eid = sc.nextInt();
		query.setParameter(1, eid);
		
		query.executeUpdate();
		System.out.println("Record Deleted");
		
		et.commit();
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
