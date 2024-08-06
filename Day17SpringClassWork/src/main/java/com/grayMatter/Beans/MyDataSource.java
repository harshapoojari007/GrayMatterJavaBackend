package com.grayMatter.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class MyDataSource {
	private String driver;
	private String url;
	private String uname;
	private String pwd;
	
	public void setup() {
		driver="com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/graymatterdb";
		uname="root";
		pwd="password";
	}
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,uname,pwd);
		return con;
	}
	
}


