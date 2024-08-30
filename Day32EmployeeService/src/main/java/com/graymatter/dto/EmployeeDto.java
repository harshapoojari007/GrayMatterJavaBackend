package com.graymatter.dto;

import com.graymatter.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
	private int id;
	private String name;
	private double salary;
	private int departmentId;
}
