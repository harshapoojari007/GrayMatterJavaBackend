package com.graymatter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.graymatter.entities.Person;

public interface PersonServiceInterface {

	public ResponseEntity<?> getAllPersons();
	public ResponseEntity<?> addPerson(Person p);
	public ResponseEntity<?> getPersonById(long id);
	public void deletePersonById(long id);
	public ResponseEntity<?> updatePerson(Person person);
}
