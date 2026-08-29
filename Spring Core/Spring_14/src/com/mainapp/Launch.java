package com.mainapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mainapp.config.MyConfiguration;

public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		
		
	}

}
