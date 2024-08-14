package com.graymatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Person;
import com.graymatter.repositories.PersonRespository;

@Repository
public class PersonDao {

	@Autowired
	PersonRespository repository;
	
	public ResponseEntity<?> getAllPersons(){
		List<Person> pList=repository.findAll();
		Map<String, Object> map=new HashMap<>();
		if(!pList.isEmpty()) {
			map.put("status",10);
			map.put("data", pList);
			return new ResponseEntity<>(map,HttpStatus.OK);
			
		}else {
			map.put("status",20);
			map.put("data", "List is empty");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	public ResponseEntity<?> updatePerson(Person person) {
		Map<String, Object> map=new HashMap<>();
		try {
			Person p=repository.findById(person.getAdhaarNumber()).get();
			p.setAge(person.getAge());
		    
			Person p1= repository.save(p);
			map.put("status",10);
			map.put("data", p1);
			return new ResponseEntity<>(map,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("status",20);
			map.put("data", "Invalid Id for updation");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	public ResponseEntity<?> addPerson(Person p) {
		Map<String, Object> map=new HashMap<>();
		try {
			Person p1= repository.save(p);
			map.put("status",10);
			map.put("data", p1);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("status",20);
			map.put("data", "Unable to add Record");
			return new ResponseEntity<>(map,HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}
	public ResponseEntity<?> deletePerson(long id) {
		
		Map<String, Object> map=new HashMap<>();
		try {
			Person p=repository.findById(id).get();
			repository.delete(p);
			map.put("status",10);
			map.put("data", "Successfully Deleted");
			return new ResponseEntity<>(map,HttpStatus.FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("status",20);
			map.put("data", "Id is not present");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
		

	}
	
	public ResponseEntity<?> getPersonById(long id) {
		Person p1= repository.findById(id).get();
		
		Map<String, Object> map=new HashMap<>();
		if(p1!=null) {
			map.put("status",10);
			map.put("data", p1);
			return new ResponseEntity<>(map,HttpStatus.FOUND);
			
		}else {
			map.put("status",20);
			map.put("data", "Id is not present");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
			
		}
	}
	
}
