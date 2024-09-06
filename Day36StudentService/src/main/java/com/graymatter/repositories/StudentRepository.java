package com.graymatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entities.Student;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findByCourseId(int courseId);

}
