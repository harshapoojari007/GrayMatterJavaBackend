package com.graymatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entities.Employee;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByDepartmentId(int departmentId);
}
