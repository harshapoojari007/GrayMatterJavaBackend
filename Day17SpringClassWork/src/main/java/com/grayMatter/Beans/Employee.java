package com.grayMatter.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@PropertySource("claspath:data.properties")
public class Employee {
@Value("${Employee.empName}")
private String empName;
@Value("${Employee.empId}")
private int empId;
@Value("${Employee.empSal}")
private double empSal;
@Autowired
private Department department;

//public Employee() {
//	super();
//}
//
//public Employee(String empName, int empId, double empSal,@Autowired Department department) {
//	super();
//	this.empName = empName;
//	this.empId = empId;
//	this.empSal = empSal;
//	this.department = department;
//}
//
//
//@Override
//	public String toString() {
//		return "Employee [empName=" + empName + ", empId=" + empId + ", empSal=" + empSal + ", department=" + department
//				+ "]";
//	}

}
