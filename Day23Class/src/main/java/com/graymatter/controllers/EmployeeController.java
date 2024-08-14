package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.entities.Employee;
import com.graymatter.exceptions.ResourceNotFoundException;
import com.graymatter.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployee();
	}
	@PostMapping("/employee")
	public Employee addEmployees(@RequestBody Employee e){
		return service.addEmployee(e);
	}
	
	@GetMapping("/employee/city/{name}")
	public List<Employee> getEmployeesByCity(@PathVariable("name") String city){
		return service.getAllEmployeeByCity(city);
	}
	
	@GetMapping("/employee/id/{id}")
	public Employee getEmployeesById(@PathVariable("id") int id) throws ResourceNotFoundException{
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/employee/deptId/{id}")
	public List<Employee> getEmployeesByDeptId(@PathVariable("id") int id){
		return service.getEmployeeByDeptId(id);
	}
	
	@GetMapping("/employee/letter/{val}")
	public List<Employee> getEmployeesByNameWithVal(@PathVariable("val") String val){
		return service.getEmployeeByNameStartWith(val);
	}
}
