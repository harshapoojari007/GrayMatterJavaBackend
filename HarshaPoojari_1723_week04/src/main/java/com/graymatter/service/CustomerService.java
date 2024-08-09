package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.CustomerDao;
import com.graymatter.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customer;
	
	
	//ADD SERVICE
	public int addCustomer(Customer c) {
		return	customer.addCustomer(c);
		
		}
	
	//DELETE SERVICE
		public int deleteCustomer(int id) {
			return	customer.deleteCustomer(id);
			
			}
		
		//UPDATE SERVICE
		public int updateCustomer(Customer p) {
			return	customer.updateCustomer(p);
			
			}
		
		//CUSTOMER SERVICE
		public Customer getCustomerById(int id) {
			return	customer.getById(id);
			
			}
		
		//ALL SERVICE
		public List<Customer> getAllCustomer() {
			return	customer.getAll();
			
			}
}
