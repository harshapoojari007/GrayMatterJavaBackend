package com.graymatter.services;

import java.util.List;

import com.graymatter.entities.Department;
import com.graymatter.entities.Employee;

public interface DepartmentServiceInterface {

	public List<Department> getAllDepartments();
	public Department addDepartment(Department e);
}
