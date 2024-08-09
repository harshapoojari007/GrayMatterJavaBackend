package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graymatter.model.Customer;


@Component
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//OPERATIONS
	
	    //Add
		public int addCustomer(Customer c)
		{
			String query="insert into customer values("+c.getId()+",'"+c.getName()+"','"+c.getEmail()+"');";
			int i=jdbcTemplate.update(query);
			return i;
		}
		
		//DELETE
		public int deleteCustomer(int id) {
			String query="delete from customer where id="+id;
			int i=jdbcTemplate.update(query);
			return i;
		}
		
		//UPDATE
		public int updateCustomer(Customer c) {
			String query="update customer set name='"+c.getName()+"',email='"+c.getEmail()+"' where id="+c.getId();
			int i=jdbcTemplate.update(query);
			return i;
		}
		
		//GET CUSTOMER BY ID
		public Customer getById(int id) {
			String query="select * from customer where id="+id;
			List<Customer> cus=jdbcTemplate.query(query, new CustomerRowMapper());
			return cus.get(0);
		}
		
		//GET ALL CUSTOMERS
		public List<Customer> getAll(){
			String query="Select * from customer";
			List<Customer> cl=jdbcTemplate.query(query, new CustomerRowMapper());
			return cl;
		}
		
	
}
