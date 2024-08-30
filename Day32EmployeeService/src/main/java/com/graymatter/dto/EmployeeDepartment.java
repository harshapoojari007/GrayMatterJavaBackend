package com.graymatter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDepartment {

	EmployeeDto empDto;
	DepartmentDto deptDto;
	
	
}
