package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.entities.Person;
import com.graymatter.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repo;
	
	public List<Person> getAllPersons(){
		return repo.findAll();
	}

	public Person addPerson(Person p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	public List<Person> getPersonsByName(String name) {
		// TODO Auto-generated method stub
		return repo.getByName(name);
	}

	public List<Person> getByNameAndAge(String name, int age) {
		// TODO Auto-generated method stub
		return repo.getByNameAndAge(name, age);
	}
	
	public List<Person> getByNameLAndAge25() {
		// TODO Auto-generated method stub
		return repo.getByNameLAndAge25();
	}
}
