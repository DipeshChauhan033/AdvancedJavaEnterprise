package com.mainapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Students {
	

	public Students() {
		System.out.println("Student Bean Instantiatation");
	}

	@PostConstruct
	public void annoinitialization() {
		System.out.println("Student Bean Initialization..");
	}

	public void test() {
		System.out.println("Student Bean Custom Method...");
	}
	
	
	@PreDestroy
	public void annoDestroy() {
		System.out.println("Student Bean Destroy");
	}

	
	
}

