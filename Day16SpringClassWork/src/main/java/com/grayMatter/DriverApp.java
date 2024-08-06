package com.grayMatter;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.grayMatter.Beans.DataSourceClass;

public class DriverApp {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
  ApplicationContext driver=new ClassPathXmlApplicationContext("DataSourceBean.xml");
  
  
  XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("DataSourceBean.xml"));
  DataSourceClass ds=(DataSourceClass)factory.getBean("dbcon");
  Connection con=ds.getConnection();System.out.println("Connection Established");
  
}
}
