package com.grayMatter;

public class HelloClass {
	public String sayHello() {
		return "helloo";
	}
public int add(int a,int b) {
	return a+b;
}
public static void main(String[] args) {
	HelloClass hc=new HelloClass();
	System.out.println(hc.sayHello());
}
}
