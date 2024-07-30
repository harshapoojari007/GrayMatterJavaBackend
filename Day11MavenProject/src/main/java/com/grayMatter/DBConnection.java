package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.EqualsAndHashCode;


public class DBConnection {
public static Connection getConnection() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatterdb","root","password");
	return con;
}
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
