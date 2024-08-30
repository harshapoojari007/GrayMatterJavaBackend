package com.graymatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.EmployeeDao;
import com.graymatter.dto.EmployeeDto;
import com.graymatter.dto.EmployeeMapper;
import com.graymatter.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Autowired
	EmployeeMapper mapper;
	
	public List<EmployeeDto> getAllEmployees(){
		List<Employee> eList= dao.getAllEmployees();
		return eList.stream().map((e)->mapper.mapToEmployeeDto(e)).collect(Collectors.toList());
		
	}
	public EmployeeDto addEmployee(EmployeeDto e) {
		return mapper.mapToEmployeeDto(dao.addEmployee(mapper.mapToEmployee(e)));
		
	}
	public void deleteEmployee(int id ){
		dao.deleteEmployee(id);
	}
	public EmployeeDto updateEmployee(EmployeeDto e) {

		return mapper.mapToEmployeeDto(dao.updateEmployee(mapper.mapToEmployee(e)));
	}
	public EmployeeDto getEmployee(int id) {
		return mapper.mapToEmployeeDto(dao.getEmployee(id));
		
	}
	public List<EmployeeDto> getAllEmployeesOfDepartment(int id) {
		// TODO Auto-generated method stub
		List<Employee> eList= dao.getAllEmployeesOfDepartment(id);
		return eList.stream().map((e)->mapper.mapToEmployeeDto(e)).collect(Collectors.toList());
	}
}
