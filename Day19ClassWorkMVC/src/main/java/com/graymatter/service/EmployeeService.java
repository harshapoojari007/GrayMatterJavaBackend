package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.EmployeeDao;
import com.graymatter.model.Employee;


@Service
public class EmployeeService {
	
@Autowired
private EmployeeDao empdao;

public List<Employee> getAllEmployee()
{
	return empdao.getAllEMployee();

}

public int addEmployee(Employee emp) {
	return empdao.addEmployee(emp);
}

public int updateEmployee(Employee emp) {
	return empdao.updateEmployee(emp);
}

public Employee getEmployeeById(int id) {
	return empdao.getEmployee(id);
}

public int deleteEmployee(int id) {
	return empdao.deleteEmployee(id);
}

}
