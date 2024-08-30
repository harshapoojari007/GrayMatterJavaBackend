package com.graymatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.DepartmentDao;
import com.graymatter.dto.DepartmentDto;
import com.graymatter.dto.DepartmentMapper;
import com.graymatter.entities.Department;



@Service
public class DepartmentService {

	@Autowired
	DepartmentDao dao;
	
	@Autowired
	DepartmentMapper mapper;
	
	public List<DepartmentDto> getAllDepartments(){
		List<Department> eList= dao.getAllDepartments();
		return eList.stream().map((e)->mapper.mapToDepartmentDto(e)).collect(Collectors.toList());
		
	}
	public DepartmentDto addDepartment(DepartmentDto e) {
		return mapper.mapToDepartmentDto(dao.addDepartment(mapper.mapToDepartment(e)));
		
	}
	public void deleteDepartment(int id ){
		dao.deleteDepartment(id);
	}
	public DepartmentDto updateEmployee(DepartmentDto e) {

		return mapper.mapToDepartmentDto(dao.updateDepartment(mapper.mapToDepartment(e)));
	}
	public DepartmentDto getDepartment(int id) {
		return mapper.mapToDepartmentDto(dao.getDepartment(id));
		
	}
}
