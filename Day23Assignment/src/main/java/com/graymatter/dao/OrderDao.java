
package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.graymatter.entities.Order;
import com.graymatter.exceptions.ResourceNotFoundException;
import com.graymatter.repositories.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	OrderRepository repo;
	
	public List<Order> getAllOrders(){
		return repo.findAll();
	}

	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	public Order getItem(int id)  throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void deleteItemId(int id) {
		// TODO Auto-generated method stub
		repo.deleteItemId(id);
	}

}
