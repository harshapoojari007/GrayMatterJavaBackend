package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Department;
import com.graymatter.repositories.DepartmentRepository;

@Repository
public class DepartmentDao {

	@Autowired
	DepartmentRepository repo;
	
	public List<Department> getAllDepartments(){
		return repo.findAll();
	}
	public Department addDepartment(Department e) {
		return repo.save(e);
	}
	public void deleteDepartment(int id ){
		repo.deleteById(id);
	}
	public Department updateDepartment(Department e) {
		return repo.save(e);
	}
	public Department getDepartment(int id) {
		return repo.findById(id).get();
	}
	
}
