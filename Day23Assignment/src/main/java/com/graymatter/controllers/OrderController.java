package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.dto.OrderDto;
import com.graymatter.exceptions.ResourceNotFoundException;
import com.graymatter.services.OrderServices;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {
	
	@Autowired
	OrderServices service;
	
	@GetMapping("/order")
	public List<OrderDto> getALlOrders(){
	   return service.getALlOrders();
	}
	
	@PostMapping("/order")
	public OrderDto addOrder(@RequestBody OrderDto order) {
		return service.addItem(order);
	}
	
	@GetMapping("/order/{id}")
	public OrderDto getOrder(@PathVariable("id") int id) throws ResourceNotFoundException
	{
		return service.getOrder(id);
	}
	
	@DeleteMapping("/order/item/{id}")
	public void deleteOrder(@PathVariable("id") int id) throws ResourceNotFoundException
	{
	  service.deleteItem(id);
	}
	

}
