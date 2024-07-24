package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DemoOnJDBC {
public static void main(String[] args) throws ClassNotFoundException, SQLException {  
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver LOaded");
	String url="jdbc:mysql://localhost:3306/graymatterdb";
	String username="root";
	String password="password";
	Connection conn=DriverManager.getConnection(url,username,password);//3 parameters
	System.out.println("Connection Established");
	
	Statement st=conn.createStatement();
	String query="select first_name, employee_id from employees";
	ResultSet rs= st.executeQuery(query);
	while(rs.next())
	{
		System.out.println(rs.getString(1)+" "+rs.getInt(2));
	}
	String query1="INSERT INTO regions values(?,?)";
	PreparedStatement ps=conn.prepareStatement(query1);
	ps.setInt(1, 7);
	ps.setString(2, "IndiaPM");
	System.out.println("Row Inserted:"+ps.executeUpdate());
	
	Statement st1=conn.createStatement();
	String query3="select * from regions";
	ResultSet rs1= st1.executeQuery(query3);
	while(rs1.next())
	{
		System.out.println(rs1.getInt(1)+" "+rs1.getString(2));
	}
	rs1.close();
	ps.close();
	rs.close();
	st.close();
	conn.close();
}
}
