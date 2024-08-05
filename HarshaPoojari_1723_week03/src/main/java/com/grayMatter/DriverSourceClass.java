package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverSourceClass {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodDeliveryDB","root","password");
		return con;
		
	}
}
