package com.mainapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.mainapp.BeanPostProcessorImpl;
import com.mainapp.Employee;

@Configuration
@ComponentScan(basePackages = {"com.mainapp"})
public class MyConfiguration {
	
	@Bean
	public static BeanPostProcessorImpl getBeanPostProcessorImpl() {
		return new BeanPostProcessorImpl();
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Lazy
	@Scope("prototype")
	public Employee getEmployee() {
		System.out.println("\""+"Custom Logic"+"\"");
		return new Employee();
	}
	
	
}

