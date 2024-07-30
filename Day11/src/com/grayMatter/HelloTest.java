package com.grayMatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {
	HelloClass hc=new HelloClass();
	
	@Test	
public void testSayHello() {
	String expected="helloo";
	
	String actual=hc.sayHello();
	assertEquals(expected, actual);
}
	
	@Test
	public void testSum() {
		int sum=hc.add(1, 3);
		assertEquals(4, sum);
	}
}
