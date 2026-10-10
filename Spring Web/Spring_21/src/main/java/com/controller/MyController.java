package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Employee;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/addmission")
public class MyController {
	
	@GetMapping("/registration.do")
	public String registrationPage() {
		System.out.println("Opened..");
		return "registration";
	}
	
	//Method 1 
//	@PostMapping("/registration.do")
//	public String registration(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		String salary = request.getParameter("salary");
//		
//		Employee emp = new Employee(id,name,address,salary);
//		
//		System.out.println(emp);
//		System.out.println("ID: "+id+" Name: "+name+" Address: "+address+" Salary: "+salary);
//		
//		return "registration";
//	}
	
	
	//Method 2
	@PostMapping("/registration.do")
	public String registration(@ModelAttribute Employee emp) {
		
		System.out.println(emp);
		return "redirect:registration.do";
	}
	
	//Method 3 - For Single Data
//	@GetMapping("/onlySelectedData.do")
//	public String registration(@RequestParam("id") int id,@RequestParam("name") String name) {
//		
//		System.out.println(id);
//		System.out.println(name);
//		return "redirect:registration.do";
//	}
	
	@GetMapping("/deleteById.do/{id}")
	public String registration(@PathVariable("id") String id) {
		
		System.out.println(id);
		return "redirect:registration.do";
	}
}
