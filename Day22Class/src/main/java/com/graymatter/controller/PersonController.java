package com.graymatter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.graymatter.entities.Person;
import com.graymatter.services.PersonServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	PersonServiceImpl service;
	
	@GetMapping("/person")
	public ResponseEntity<?> getAllPersons(){
		return service.getAllPersons();
		
	}
	
	@PostMapping("/person")
	public ResponseEntity<?> addPerson(@RequestBody Person p){
		return service.addPerson(p);
		
	}
	@GetMapping("/person/{id}")
	public ResponseEntity<?> getPerson(@PathVariable("id") long id){
		return service.getPersonById(id);
		
	}
	
	@DeleteMapping("/person/{id}")
		public void deletePerson(@PathVariable("id") long id) {
			service.deletePersonById(id);
		}
@PutMapping("/person")
	public ResponseEntity<?> updatePerson(@RequestBody Person p) {
		return service.updatePerson(p);
	}
}

