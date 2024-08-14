package com.graymatter.services;

import java.util.List;

import com.graymatter.entities.Employee;

public interface EmployeeServiceInterface {

	public List<Employee> getAllEmployee();
	public Employee addEmployee(Employee e);
	
}
