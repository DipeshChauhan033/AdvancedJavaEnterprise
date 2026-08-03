package com.mainapp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean,DisposableBean{
	

	public Employee() {
		System.out.println("EMP Bean Instantiatation");
	}
	
//	XML Approach
//	public void xmlinitialization() {
//		System.out.println("Resource Allocation..");
//	}
	
	
//	Annotation Approach
//	@PostConstruct
//	public void annoinitialization() {
//		System.out.println("Resource Allocation..");
//	}
	
	//CallBack Approach
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Resource Allocation..");
	}
	
	
	
	public void test() {
		System.out.println("EMP Bean Tested...");
	}
	
	
	
//	XML Approach
//	Destroy
//	public void xmlDestroy() {
//		System.out.println("Resource De-Allocation");
//	}
	
//	Annotation Approach
//	Destroy
//	@PreDestroy
//	public void annoDestroy() {
//		System.out.println("Resource De-Allocation");
//	}

	
	//CallBack Approach
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Resource De-Allocation");
	}
	
}

