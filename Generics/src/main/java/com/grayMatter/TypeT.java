package com.grayMatter;

public class TypeT<T>{
    T message;
    public void setMessage(T m) {
    	this.message=m;
    }
    public void sendMessage() {
    	System.out.println("Hii "+message+"!! From class TypeT!!");
    }
	public static void main(String[] args) {
		TypeT<String> t=new TypeT<String>();
		t.setMessage("Harsha");
		t.sendMessage();
		
	}
}
