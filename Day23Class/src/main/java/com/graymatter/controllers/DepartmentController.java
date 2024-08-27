package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.entities.Department;
import com.graymatter.entities.Employee;
import com.graymatter.services.DepartmentService;
import com.graymatter.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@GetMapping("/department")
	public List<Department> getAllDepartment(){
		return service.getAllDepartments();
	}
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department d){
		
//		   Department d2 = new Department();
//	        d2.setName(d.getName());
////	        d2.setId(d.getId());
//
//	        for (Employee empReq : d.getEmployee()) {
//	            Employee employee = new Employee();
//	            employee.setName(empReq.getName());
//	            employee.setSalary(empReq.getSalary());
//	            employee.setCity(empReq.getCity());
//	            employee.setDepartment(d2);
//	            d2.getEmployee().add(employee);
//	        }
		return service.addDepartment(d);
		
	}

	@DeleteMapping("/department/{id}")
	public void deleteDepartment(@PathVariable("id")int id) {
		service.deleteMapping(id);
	}
	
}
