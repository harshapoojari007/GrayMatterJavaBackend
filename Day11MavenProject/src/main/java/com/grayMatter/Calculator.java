package com.grayMatter;

public class Calculator {
	public static int add(int a,int b) {
		return a+b;
	}
	public static int sub(int a,int b) {
		return a-b;
	}
	public static int mul(int a,int b) {
		return a*b;
	}
	public static double div(int a,int b) {
		return (float)a/b;
	}
	
	public static boolean testIsEven(int a) {
		return a%2==0;
	    
	}
	public static int [] arrayEquals(int a[]) {
		return a;
	}
	
	public static String checkString() {
		return null;
	}
	
	public static  Student createStudent() {
		
		Student s=new Student("Harsha",123,43);
		return s;
	}
}
