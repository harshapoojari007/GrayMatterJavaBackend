package com.graymatter.dto;

import org.springframework.stereotype.Component;

import com.graymatter.entities.Employee;

@Component
public class EmployeeMapper {

	public Employee mapToEmployee(EmployeeDto employee) {
		return new Employee(employee.getId(),employee.getName(),employee.getSalary(),employee.getDepartmentId());
	}
	public EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(),employee.getName(),employee.getSalary(),employee.getDepartmentId());
	}
	
}
