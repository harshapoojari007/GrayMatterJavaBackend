package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.graymatter.entities.Student;
import com.graymatter.services.StudentService;


@RestController
@RequestMapping("/api/v1")
public class StudentControler {
	@Autowired
	StudentService service;

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}
	
	@GetMapping("/studnets/course/{id}")
	public List<Student> getStudentBtCOurseId(@PathVariable int id) {
		return service.getStudentBtCOurseId(id);
	}
}
