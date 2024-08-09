package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graymatter.model.Customer;
import com.graymatter.model.Order;

@Component
public class OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//OPERATIONS
	
	    //Add
		public int addOrder(Order o)
		{
			String query="insert into orders values("+o.getId()+",'"+o.getOrderDate()+"',"+o.getTotalAmount()+","+o.getCustomerId()+");";
			int i=jdbcTemplate.update(query);
			return i;
		}
		
		//DELETE
		public int deleteOrder(int id) {
			String query="delete from orders where id="+id;
			int i=jdbcTemplate.update(query);
			return i;
		}
		
		//UPDATE
		public int updateOrder(Order o) {
			String query="update orders set totalAmount="+o.getTotalAmount()+"where id="+o.getId();
			int i=jdbcTemplate.update(query);
			return i;
		}
		
		//GET ORDER BY ID
		public Order getById(int id) {
			String query="select * from orders where id="+id;
			List<Order> os=jdbcTemplate.query(query, new OrderRowMapper());
			return os.get(0);
		}
		
		//GET ALL ORDERS
		public List<Order> getAll(){
			String query="Select * from orders";
			List<Order> ol=jdbcTemplate.query(query, new OrderRowMapper());
			return ol;
		}
		
		//GET ORDERS OF PARTICULAR CUSTOMER
		public List<Order> getOrderCustomer(int id){
			String query="Select * from orders where customerId="+id;
			List<Order> ol=jdbcTemplate.query(query, new OrderRowMapper());
			return ol;
			
		}
}
