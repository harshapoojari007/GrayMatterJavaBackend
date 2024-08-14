package com.graymatter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.EmployeeDao;
import com.graymatter.entities.Employee;
import com.graymatter.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
	EmployeeDao dao;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return dao.addEmployee(e);
	}

	public List<Employee> getAllEmployeeByCity(String city) {
		// TODO Auto-generated method stub
		return dao.getAllEmployeeByCity(city);
	}

	public Employee getEmployeeById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	public List<Employee> getEmployeeByDeptId(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByDeptId(id);
	}

	public List<Employee> getEmployeeByNameStartWith(String val) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByNameStartWith(val);
	}

}
