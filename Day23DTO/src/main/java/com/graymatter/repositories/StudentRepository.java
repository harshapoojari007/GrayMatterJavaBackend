package com.graymatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}
