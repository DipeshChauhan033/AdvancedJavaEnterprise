package com.mainapp;

import javax.persistence.EntityManager;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.mainapp.entity.Employee;


public class Launch {
	public static void main(String args[]){
		
		try {
			InputStream inputStream = Launch.class.getClassLoader().getResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			
			Map<String, String> map = new HashMap<String, String>();
			Set<String> stringPropertyNames = properties.stringPropertyNames();
			
			for(String key:stringPropertyNames) {
				map.put(key, properties.getProperty(key));
			}
			
			HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
			EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider.createContainerEntityManagerFactory(new PersistenceUnitInfoImpl(), map);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		
			
			Scanner sc = new Scanner(System.in);
			String choice;
			do {
				System.out.println();
				System.out.print("Enter (insert) to add employee details,\nEnter (read) to read employee details,\nEnter (update) to update employee details,\nEnter (delete) to remove employee details,\nEnter (exit) to stop work on employee data:");
				System.out.println();
				choice = sc.nextLine().toLowerCase().trim();
				
				if(choice.equals("insert")) {
					insert(entityManager);
				}
				else if(choice.equals("read")) {
					System.out.println("-----------------------------Employee Details-----------------------------------");
					read(entityManager);
					
				}
				else if(choice.equals("update")) {
					update(entityManager);
				}
				else if(choice.equals("delete")) {
					delete(entityManager);
				}
				else if(choice.equals("exit")){
					break;
				}
				else {
					System.out.println("invalid input, please enter valid input..");
				}
			}while(10!=0);
			
			entityManager.close();
			entityManagerFactory.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
	private static void insert(EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee id: ");
		int eid = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter employee name: ");
		String ename = sc.nextLine();
		
		System.out.println("Enter employee permanent address: ");
		String eaddress = sc.nextLine();
		
		System.out.println("Enter employee salary: ");
		double esalary = sc.nextDouble();
		
		Employee ebind2 = new Employee(eid,ename,eaddress,esalary);
		entityManager.persist(ebind2);
		System.out.println("Inserted successfully..");
		transaction.commit();
	}
	
	private static void read(EntityManager entityManager) {
		System.out.print("\n");//For space
		
		/* Employee empdt = entityManager.find(Employee.class, 101);
		System.out.println(empdt);------Single row*/
		
		//to read all data
		List<Employee> list = (List<Employee>) entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
		
		for(Employee e:list) {
			System.out.println(e);
		}
	}
	
	private static void update(EntityManager entityManager) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id to change details: ");
		int eid = sc.nextInt();
		
		Employee empdt = entityManager.find(Employee.class, eid);
		if(empdt!=null) {
			
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			empdt.setEsalary(2500);
			entityManager.merge(empdt);
			transaction.commit();
			System.out.println("Salary updated successfully..");
		}
		else {
			System.out.println("Enter valid employee id..");
		}
	}
	
	private static void delete(EntityManager entityManager) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id to delete details: ");
		int eid = sc.nextInt();
		
		Employee empdt = entityManager.find(Employee.class, eid);
		if(empdt!=null) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.remove(empdt);
			
			transaction.commit();
			System.out.println("Deleted..");
		}
		else {
			System.out.println("Invalid Employee id...");
		}
	}
}
