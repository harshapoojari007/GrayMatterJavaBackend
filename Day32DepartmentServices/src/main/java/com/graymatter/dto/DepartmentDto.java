package com.graymatter.dto;

import java.util.ArrayList;
import java.util.List;

import com.graymatter.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private int id;
	private String name;
	private List<EmployeeDto> employees=new ArrayList<>();
}
