package com.graymatter.entities;

import java.util.List;

import com.graymatter.dtos.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

	@Id
	private int id;
	private String name;
	
	@Transient
	private  List<Student> studentList;
}
