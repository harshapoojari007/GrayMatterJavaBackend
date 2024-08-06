package com.grayMatter.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.grayMatter.Beans.Customer;
import com.grayMatter.Beans.Item;
import com.grayMatter.Beans.Order;

@ComponentScan("com.grayMatter.Beans")
public class OrderConfig {

	
	@Bean(name="cust")
	public Customer getCustomer() {
		return new Customer(123,"12345678","hp@gmai.com",getOrder());
	}
	@Bean(name="order")
	public Order getOrder() {
		return new Order(12,"12/12/2003",getItem());
	}
	@Bean(name="item")
	public List<Item> getItem() {
		List<Item> li=new ArrayList<Item>();
		li.add(new Item(1,"corn",100));
		li.add(new Item(2,"biscuit",30));
		li.add(new Item(3,"lays",10));
		return li;
	}
	
	
	
	
}
