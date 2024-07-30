package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverClass {
	public Connection getCOnnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/graymatterdb";
		String root="root";
		String password="password";
		Connection con=DriverManager.getConnection(url,root,password);
	    return con;
	}

	
}
