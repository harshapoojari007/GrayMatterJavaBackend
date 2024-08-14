package com.graymatter.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.graymatter.dto.StudentDto;
import com.graymatter.dto.StudentMapper;
import com.graymatter.entities.Student;
import com.graymatter.repositories.StudentRepository;

@Service
@Profile(value="development")
public class StudentServices {

	@Autowired
	StudentRepository repository;

	@Autowired
	StudentMapper mapper;
	
	public List<StudentDto> getAllStudents() {
		List<Student> sList=repository.findAll();
		return sList.stream().map((stu)->mapper.mapToStudentDto(stu)).collect(Collectors.toList());
	}	
	
	public StudentDto addStudent(StudentDto studentDto) {
		return mapper.mapToStudentDto(repository.save(mapper.mapToStudent(studentDto)));
	}
	
	
}
