package com.grayMatter;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
     //   assertTrue( true );
    }
    
    @Test
    public void testAdd() {
     Assertions.assertEquals(1, 1+2);
    }
}