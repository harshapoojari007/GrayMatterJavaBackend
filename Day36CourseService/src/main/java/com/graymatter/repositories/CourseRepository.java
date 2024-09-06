package com.graymatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
