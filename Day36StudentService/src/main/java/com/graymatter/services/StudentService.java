package com.graymatter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.graymatter.entities.Student;
import com.graymatter.repositories.StudentRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public Student addStudent(Student s) {
		return repository.save(s);
	}
	
	public List<Student> getStudentBtCOurseId(int id) {
		return repository.findByCourseId(id);
	}

}
