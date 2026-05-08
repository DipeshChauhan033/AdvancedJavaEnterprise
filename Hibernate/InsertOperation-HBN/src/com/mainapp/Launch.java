package com.mainapp;

import javax.persistence.EntityManager;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mainapp.entity.Employee;

public class Launch {
	public static void main(String args[]){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myCon");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager);
		
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
		
		Employee ebind = new Employee(eid,ename,eaddress,esalary);
		entityManager.persist(ebind);
		transaction.commit();
		System.out.println("Details entered successfully..");
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
