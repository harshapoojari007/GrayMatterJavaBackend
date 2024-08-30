package com.graymatter.dto;

import org.springframework.stereotype.Component;

import com.graymatter.entities.Department;

@Component
public class DepartmentMapper {
	public Department mapToDepartment(DepartmentDto department) {
		return new Department(department.getId(),department.getName(),department.getEmployees());
	}
	public DepartmentDto mapToDepartmentDto(Department department) {
		return new DepartmentDto(department.getId(),department.getName(),department.getEmployees());
	}
}
