package com.graymatter.entities;

import java.util.ArrayList;
import java.util.List;

import com.graymatter.dto.EmployeeDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="service_department")
public class Department {

	@Id
	private int id;
	private String name;
	

	
	
	@Transient
	private List<EmployeeDto> employees=new ArrayList<>();
}
