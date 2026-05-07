package com.mainapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Launch {
	public static void main(String args[]){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myCon");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
