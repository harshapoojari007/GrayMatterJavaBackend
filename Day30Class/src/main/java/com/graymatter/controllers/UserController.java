package com.graymatter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/")
public class UserController {

	@GetMapping("/hello")
	public String sayHello() {
		return "login";
	}
	
	
	
}
