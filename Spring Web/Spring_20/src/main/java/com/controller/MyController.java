package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addmission") // '/' is optional..
public class MyController {
	
	@GetMapping("/registration.do")
	public String registrationArea() {
		System.out.println("/Tested..");
		
		return "registration";
	}
}
