package com.grayMatter.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceClass {
	private String driverName;
private String url;
private String username;
private String password;
public DataSourceClass() {
	super();
}
public DataSourceClass(String driverName, String url, String username, String password) {
	super();
	this.driverName = driverName;
	this.url = url;
	this.username = username;
	this.password = password;
}
@Override
public String toString() {
	return "DataSourceClass [driverName=" + driverName + ", url=" + url + ", username=" + username + ", password="
			+ password + "]";
}
public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public Connection getConnection() throws SQLException, ClassNotFoundException {
	Class.forName(driverName);
	Connection con=DriverManager.getConnection(url,username,password);
	return con;
}

}
