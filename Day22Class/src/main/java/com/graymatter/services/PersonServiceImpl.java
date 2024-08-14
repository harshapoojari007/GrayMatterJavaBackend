package com.graymatter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.graymatter.dao.PersonDao;
import com.graymatter.entities.Person;

@Service
public class PersonServiceImpl implements PersonServiceInterface{

	@Autowired	
	PersonDao person;
	
	@Override
	public ResponseEntity<?> getAllPersons() {
		// TODO Auto-generated method stub
		return person.getAllPersons();
	}

	@Override
	public ResponseEntity<?> addPerson(Person p) {
		// TODO Auto-generated method stub
		return person.addPerson(p);
		
	}

	@Override
	public ResponseEntity<?> getPersonById(long id) {
		// TODO Auto-generated method stub
		return person.getPersonById(id);
	}

	@Override
	public void deletePersonById(long id) {
		// TODO Auto-generated method stub
		person.deletePerson(id);
		
	}
    
	public ResponseEntity<?> updatePerson(Person p) {
		return person.updatePerson(p);
	}
}
