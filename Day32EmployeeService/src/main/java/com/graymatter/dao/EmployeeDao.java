package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Employee;
import com.graymatter.repositories.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	public Employee addEmployee(Employee e) {
		return repo.save(e);
	}
	public void deleteEmployee(int id ){
		repo.deleteById(id);
	}
	public Employee updateEmployee(Employee e) {
		return repo.save(e);
	}
	public Employee getEmployee(int id) {
		return repo.findById(id).get();
	}
	public List<Employee> getAllEmployeesOfDepartment(int id) {
		// TODO Auto-generated method stub
		return repo.findByDepartmentId(id);
	}
	
}
