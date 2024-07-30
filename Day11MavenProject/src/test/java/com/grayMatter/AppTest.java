package com.grayMatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
	@Test
	@Category(MarkerInterface.class)
    public void testPrintName() {
    	assertEquals("Harsha",App.printName("Harsha"));
    
    }
	
	@Test
	public void testGetCon() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatterdb","root","password");
		assertEquals(con, DBConnection.getConnection());
	}
}
