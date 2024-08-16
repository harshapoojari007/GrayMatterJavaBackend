package com.graymatter.dto;

import org.springframework.stereotype.Component;

import com.graymatter.entities.Order;

@Component
public class OrderMapper {
	public Order mapToOrder(OrderDto orderDto) {
		return new Order(orderDto.getOrderId(),orderDto.getDate(),orderDto.getItems());
	}
	public OrderDto mapToOrderDto(Order order) {
		return new OrderDto(order.getOrderId(),order.getDate(),order.getItems());
	}

}
