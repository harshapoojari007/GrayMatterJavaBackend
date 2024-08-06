package com.grayMatter.Beans;

import java.util.List;

public class Order {
private int orderID;
private List<String> itemList;
public int getOrderID() {
	return orderID;
}
public void setOrderID(int orderID) {
	this.orderID = orderID;
}
public List<String> getItemList() {
	return itemList;
}
public void setItemList(List<String> itemList) {
	this.itemList = itemList;
}
@Override
public String toString() {
	return "Order [orderID=" + orderID + ", itemList=" + itemList + "]";
}
public Order(int orderID, List<String> itemList) {
	super();
	this.orderID = orderID;
	this.itemList = itemList;
}
public Order() {
	super();
}
}
