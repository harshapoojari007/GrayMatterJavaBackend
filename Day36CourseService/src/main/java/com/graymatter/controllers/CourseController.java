package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.entities.Course;
import com.graymatter.services.CourseService;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

	
	@Autowired
	CourseService service;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return service.getAllCourses();
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return service.addCourse(course);
	}
	
	@GetMapping("/course/{id}")
		public Course getCourseById(@PathVariable int id) {
			return service.getCourseById(id);
		}
	}

