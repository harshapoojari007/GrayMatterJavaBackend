package com.graymatter.entities;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.graymatter.dtos.Student;

@FeignClient(name="Day36StudentService")
public interface CourseClient {
//	@GetMapping("/courses")
//	public List<Course> getAllCourses();
//	
//	@PostMapping("/course")
//	public Course addCourse(@RequestBody Course course);
//	
//	@GetMapping("/course/{id}")
//	public Course getCourseById(@PathVariable int id);
	
	@GetMapping("/studnets/course/{id}")
	public List<Student> getStudentsByCOurseId(@PathVariable int id);

}
