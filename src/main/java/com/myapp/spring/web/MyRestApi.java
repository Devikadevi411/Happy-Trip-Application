package com.myapp.spring.web;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyRestApi {
	
	@GetMapping
	public String sayHello() {
		
		return "Welcome To World Of Rest Api With Java Spring and Current Date "
		+LocalDate.now();
	}
	
	@GetMapping("/hello")
	public String sayHello1() {
		
		return "Welcome To World Of Rest Api With Java1 Spring and Current Date "
		+LocalDate.now();
	}


}
