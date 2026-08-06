package com.mainapp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor{
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println("postProcessBeforeInitialization"); //Common, For all Bean(Class)
		
		if(bean instanceof Employee) {
			System.out.println("Employee Specific Work..Ex: Password Decrypt");
			System.out.println("");
		}
		else if(bean instanceof Manager) {
			System.out.println("Manager Specific Work.. Ex: Bean is properly instantiated And Dependencies are injected for the bean "+beanName);
			System.out.println("");
		}
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("");
		System.out.println("postProcessAfterInitialization");
		return bean;
		
	}
}
