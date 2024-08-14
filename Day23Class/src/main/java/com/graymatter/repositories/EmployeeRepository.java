package com.graymatter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.graymatter.entities.Department;
import com.graymatter.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> findByCity(String city);
	
	//@Query(value="select* from class_employee e where e.dept_id=?",nativeQuery = true)
	public List<Employee> findByDepartmentId(int id);
	
//   @Query(value="select* from class_employee e where e.name LIKE ?%",nativeQuery = true)
	public List<Employee> findByNameStartsWith(String letter);
	
	
	
	@Query("select e from Employee e where name like ?1")
	public List<Employee> findByNameLike(@Param("val") String letter);
}
