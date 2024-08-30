package com.graymatter.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.graymatter.dto.DepartmentDto;
import com.graymatter.dto.EmployeeDepartment;
import com.graymatter.dto.EmployeeDto;
import com.graymatter.entities.Employee;
import com.graymatter.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	
	@GetMapping("/employee")
	public List<EmployeeDto> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@PostMapping("/employye")
	public EmployeeDto addEmployee(@RequestBody EmployeeDto e) {
		return service.addEmployee(e);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id ){
		service.deleteEmployee(id);
	}
	
	@PutMapping("/employee")
	public EmployeeDto updateEmployee(@RequestBody  EmployeeDto e) {
		return service.updateEmployee(e);
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeDto getEmployee(@PathVariable("id")  int id) {
		return service.getEmployee(id);
	}
	
	@GetMapping("/employee/dept/{id}")
	public List<EmployeeDto>getEmployeesByDeptId(@PathVariable("id")  int id) {
		return service.getAllEmployeesOfDepartment(id);
	}
	
//	@GetMapping("/employee/department/{id}")
//	public List<EmployeeDepartment> getAllEmployeesOfDepartment(@PathVariable("id") int id) {
//		String url="http://localhost:8087/department/"+id;
//		DepartmentDto deptDto=restTemplate.getForObject(url, DepartmentDto.class);
//		List<EmployeeDto> eList=service.getAllEmployeesOfDepartment(id);
//		List<EmployeeDepartment> edList=eList.stream().map((e)->new EmployeeDepartment(e, deptDto)).collect(Collectors.toList());
//		return edList;
//	}
	
}
