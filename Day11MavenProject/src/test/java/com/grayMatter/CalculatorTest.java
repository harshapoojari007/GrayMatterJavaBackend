package com.grayMatter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CalculatorTest {
@Test
	public void testAdd() {
	assertEquals(1, Calculator.add(0, 1));

	

	}
@Test
public void testSub() {
	assertEquals(-1, Calculator.sub(0, 1));
}
@Test
public void testMul() {
	assertEquals(0, Calculator.mul(0, 1));
}
@Test
public void testDiv() {
	assertEquals((Double)1.0,(Double)Calculator.div(1, 1));

}

@Test
public void testEven() {
	assertTrue(Calculator.testIsEven(24));
}



@Test
@Category(MarkerInterface.class)
public void testArrayEquals() {
	int expArray[]= {34,56,78,12,78};
	int actualArray[]={34,56,78,12,78};
	assertArrayEquals(expArray, Calculator.arrayEquals(actualArray));
}

@Test
@Category(MarkerInterface.class)
public void isNUll() {
	assertNull(Calculator.checkString());
}

@Before
public void printLogBeforeMethod() {
	System.out.println("Before EveryTest");
}

@After
public void printLogAftereMethod() {
	System.out.println("After EveryTest");
}

@BeforeClass
public static void beforeClassMethod() {
	System.out.println("Print Before Class");
}

@AfterClass
public static void afterClassMethod() {
	System.out.println("Print After Class");
}

@Test

public void testCreateStudent() {
	Student expStudent=new Student("Harsha",123,43);
	assertEquals(expStudent, Calculator.createStudent());
}

static Connection con=null;
@BeforeClass
public static void testGetCon() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatterdb","root","password");
	
}
@Test
public void testConnection() {
	assertNotNull(con);
}
}
