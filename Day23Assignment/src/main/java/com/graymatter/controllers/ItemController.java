package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.dto.ItemDto;
import com.graymatter.entities.Item;
import com.graymatter.exceptions.ResourceNotFoundException;
import com.graymatter.services.ItemServices;

@RestController
@RequestMapping("/api/v1/")
public class ItemController {

	@Autowired
	ItemServices service;
	
	@GetMapping("/item")
	public List<ItemDto> getAllItems(){
		return service.getAllItems();
		
	}
	
	@PostMapping("/item")
	public ItemDto addItem(@RequestBody ItemDto item) {
		return service.addItem(item);
	}
	
	@GetMapping("/item/{id}")
	public ItemDto getItem(@PathVariable("id") int id) throws ResourceNotFoundException
	{
		return service.getItem(id);
	}
	
	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable("id") int id) throws ResourceNotFoundException
	{
	service.deleteItem(id);
	}
}
