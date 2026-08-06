package com.mainapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Manager {
	

	public Manager() {
		System.out.println("Manager Bean Instantiatation");
	}

	@PostConstruct
	public void annoinitialization() {
		System.out.println("Manager Bean Initialization..");
	}

	public void test() {
		System.out.println("EMP Bean Custom Method...");
	}
	
	
	@PreDestroy
	public void annoDestroy() {
		System.out.println("Manager Bean Destroy");
	}

	
	
}

