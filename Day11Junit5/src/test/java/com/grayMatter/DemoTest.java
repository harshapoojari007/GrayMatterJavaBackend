package com.grayMatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoTest {
@Test
public void testPrintName() {
	Assertions.assertEquals("user", DemoClass.printName("user"));
}

@BeforeEach
public void printBefore() {
	System.out.println("Before each Test");
}

@AfterEach
public void printAfter() {
	System.out.println("After each Test");
}

@BeforeAll
public void printBeforeClass() {
	System.out.println("Before CLass");
}

@AfterAll
public void printAfterClass(){
	System.out.println("After Class");
}

}
