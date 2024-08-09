package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.OrderDao;
import com.graymatter.model.Customer;
import com.graymatter.model.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDao order;
	
	//ADD SERVICE
	public int addOrder(Order o) {
		return	order.addOrder(o);
		
		}
	
	//DELETE SERVICE
		public int deleteOrder(int id) {
			return	order.deleteOrder(id);
			
			}
		
		//UPDATE SERVICE
		public int updateOrder(Order o) {
			return	order.updateOrder(o);
			
			}
		
		//BY ID SERVICE
		public Order getOrderById(int id) {
			return	order.getById(id);
			
			}
		
		//ALL ORDER SERVICE
		public List<Order> getAllOrder() {
			return	order.getAll();
			
			}
		
		//BY CUSTOMER SERVICE
		public List<Order> getOrderByCustomer(int id){
			return order.getOrderCustomer(id);
		}
	
}
