package com.grayMatter.Beans;

public class Customer {
private String name;
private int id;
private String mobile;

private Order order;
public Customer() {
	super();
}
public Customer(String name, int id, String mobile) {
	super();
	this.name = name;
	this.id = id;
	this.mobile = mobile;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public Customer(String name, int id, String mobile, Order order) {
	super();
	this.name = name;
	this.id = id;
	this.mobile = mobile;
	this.order = order;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "Customer [name=" + name + ", id=" + id + ", mobile=" + mobile + ", order=" + order + "]";
}

}
