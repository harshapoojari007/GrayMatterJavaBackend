package com.graymatter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.graymatter.dtos.Student;
import com.graymatter.entities.Course;
import com.graymatter.entities.CourseClient;
import com.graymatter.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository repo;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	CourseClient courseClient;
	
	public List<Course> getAllCourses(){
		return repo.findAll();
	}
	
	public Course getCourseById(int id) {
		Course course=repo.findById(id).get();
		//List<Student> studentList=(List<Student>) restTemplate.getForObject("http://Day36StudentService/studnets/course/"+id, ArrayList.class);
		List<Student> studentList=courseClient.getStudentsByCOurseId(id);
		course.setStudentList(studentList);
	return course;
	}

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return repo.save(course);
	}
	
   
	
}