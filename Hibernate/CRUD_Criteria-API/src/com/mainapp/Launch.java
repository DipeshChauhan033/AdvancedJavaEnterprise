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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		Scanner sc = new Scanner(System.in);
		
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
		/*
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		
		Root<Employee> from = criteriaQuery.from(Employee.class);
		criteriaQuery.select(from);
		
		TypedQuery<Employee> query = em.createQuery(criteriaQuery);
		List<Employee> resultList = query.getResultList();
		System.out.println(resultList);
		*/ //Bulk read
		
		//Specific..
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		
		Root<Employee> from = criteriaQuery.from(Employee.class);
		//criteriaQuery.select(from); //for all the data
		
		//With Condition
		Predicate p1 = criteriaBuilder.greaterThan(from.get("eid"), 103);
		//criteriaQuery.where(p1);
		
		//Double condition 
		Predicate p2 = criteriaBuilder.like(from.get("ename"), "%m%");
		criteriaQuery.where(p1,p2);
		
		TypedQuery<Employee> query = em.createQuery(criteriaQuery);
		List<Employee> resultList = query.getResultList();
		System.out.println(resultList);
	}
	
	private static void update(EntityManager em) {
	
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Employee.class);
		
		Root<Employee> from = criteriaUpdate.from(Employee.class);
		
		criteriaUpdate.set("esalary", 50000);
		Predicate p1 = criteriaBuilder.greaterThan(from.get("eid"), 103);
		criteriaUpdate.where(p1);
		
		Query query = em.createQuery(criteriaUpdate);
		query.executeUpdate();
	
		et.commit();
		System.out.println("Updated..");
	}
	
	private static void delete(EntityManager em) {
		
		Scanner sc = new Scanner(System.in);
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<Employee> criteriaDelete = criteriaBuilder.createCriteriaDelete(Employee.class);
		
		Root<Employee> from = criteriaDelete.from(Employee.class);
		System.out.println("Enter eployee id to delete: ");
		int eid = sc.nextInt();
		Predicate p1 = criteriaBuilder.equal(from.get("eid"), eid);
		criteriaDelete.where(p1);
		
		Query query = em.createQuery(criteriaDelete);
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
