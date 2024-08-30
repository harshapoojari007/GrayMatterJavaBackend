package com.graymatter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.graymatter.config.AppConfig;
import com.graymatter.dto.DepartmentDto;
import com.graymatter.dto.EmployeeDto;
import com.graymatter.services.DepartmentService;



@RestController
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@Autowired
    RestTemplate restTemplate;
	
	@GetMapping("/department")
	public List<DepartmentDto> getAllDepartments(){
		return service.getAllDepartments();
	}
	
	@PostMapping("/department")
	public DepartmentDto addDepartment(@RequestBody DepartmentDto d) {
		return service.addDepartment(d);
	}
	
	@DeleteMapping("/department/{id}")
	public void deleteDepartment(@PathVariable("id") int id ){
		service.deleteDepartment(id);
	}
	
	@PutMapping("/department")
	public DepartmentDto updateDepartment(@RequestBody  DepartmentDto e) {
		return service.updateEmployee(e);
	}
	
	@GetMapping("/department/{id}")
	public DepartmentDto getDepartment(@PathVariable("id")  int id) {
		return service.getDepartment(id);
	}
	
	@GetMapping("/emp/dept/{id}")
	public DepartmentDto getEmployeeDepartment(@PathVariable("id") int id) {
		DepartmentDto dept=service.getDepartment(id);
		
		String url="http://DAY32EMPLOYEESERVICE/employee/dept/"+id;
		ArrayList<EmployeeDto> empList=restTemplate.getForObject(url, ArrayList.class);
        dept.setEmployees(empList);
        return dept;
	}
	
}
