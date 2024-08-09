package com.graymatter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.graymatter.service.CustomerService;
import com.graymatter.service.OrderService;

@Controller
public class ManagementController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	
	
	
	
}
