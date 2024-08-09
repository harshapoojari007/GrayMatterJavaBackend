package com.graymatter.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.graymatter.model.Employee;

public class EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
//CRUD Operation
	
	
	//insert
	public int addEmployee(Employee emp) {
		
		String query="insert into employee values('"+emp.getEmpName()+"',"+ emp.getEmpId()+","+emp.getEmpSalary()+");";
		int i=jdbcTemplate.update(query);
		return i;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	//select
	public List<Employee> getAllEMployee(){
		String query="select * from employee";
		
		List<Employee> empList=jdbcTemplate.query(query, new EmployeeRowMapper());
		return empList;
	 
	}
	
	//update
	public int updateEmployee(Employee emp) {
		String query="update employee set salary="+emp.getEmpSalary()+"where id="+emp.getEmpId();
		return jdbcTemplate.update(query);
	}
	
	//delete
	public int deleteEmployee(int id) {
		String query="delete from employee where id="+id;
		return jdbcTemplate.update(query);
	}
	
	//byId
		public Employee getEmployee(int id) {
			String query="select * from employee where id="+id;
			List<Employee> empList=jdbcTemplate.query(query, new EmployeeRowMapper());
			return empList.get(0);
		 
		}
}
