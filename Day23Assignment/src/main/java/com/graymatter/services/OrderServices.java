package com.graymatter.services;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.OrderDao;
import com.graymatter.dto.OrderDto;
import com.graymatter.dto.OrderMapper;
import com.graymatter.entities.Order;
import com.graymatter.exceptions.ResourceNotFoundException;


@Service
public class OrderServices implements OrderServicesInterface{
	
	@Autowired
	OrderDao dao;
	
	@Autowired
	OrderMapper mapper;

	public List<OrderDto> getALlOrders() {
		// TODO Auto-generated method stub
		List<Order> oList=dao.getAllOrders();
		
		return oList.stream().map((order)->mapper.mapToOrderDto(order)).collect(Collectors.toList());
	}

	public OrderDto addItem(OrderDto order) {
		// TODO Auto-generated method stub
		return mapper.mapToOrderDto(dao.addOrder(mapper.mapToOrder(order)));
	}

	public OrderDto getOrder(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return mapper.mapToOrderDto(dao.getItem(id));
	}

	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		dao.deleteItemId(id);
	}

}
