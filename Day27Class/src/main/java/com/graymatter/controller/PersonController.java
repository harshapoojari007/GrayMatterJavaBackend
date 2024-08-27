package com.graymatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.entities.Person;
import com.graymatter.service.PersonService;

@RestController
@RequestMapping("/api/v1/")
public class PersonController {
	
	@Autowired
	PersonService service;

	@GetMapping("/person")
	public List<Person> getALLPersons(){
		return service.getAllPersons();
	}
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person p){
		return service.addPerson(p);
	}
	
	@GetMapping("/person/name/{name}")
	public List<Person> getPersonsByName(@PathVariable("name") String name){
		return service.getPersonsByName(name);
	}
	@GetMapping("/person/name/{name}/age/{age}")
	public List<Person> getByNameAndAge(@PathVariable("name") String name,@PathVariable("age") int age){
		return service.getByNameAndAge(name,age);
	}
	
	@GetMapping("/person/l25")
	public List<Person> getByNameLAndAge25(){
		return service.getByNameLAndAge25();
	}
}
