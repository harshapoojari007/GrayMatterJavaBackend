package com.grayMatter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.graymatter.beans.Book;
import com.grayMatter.Beans.Customer;
import com.grayMatter.Beans.DbUtils;
import com.grayMatter.Beans.MyDataSource;
//import com.graymatter.beans.Employee;
import com.grayMatter.Beans.Order;
import com.grayMatter.Beans.Regions;
//import com.graymatter.config.BookConfig;
import com.grayMatter.config.OrderConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("emp-bean.xml");
//        Employee emp = context.getBean(Employee.class);
//        System.out.println(emp);
 
//        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
//        Book book = (Book) context.getBean("book");
//        System.out.println(book);
        
//     
     ApplicationContext context = new AnnotationConfigApplicationContext(OrderConfig.class);
//        Order order = (Order) context.getBean("order");
//        System.out.println(order);
//     
//        Customer customer = (Customer) context.getBean("customer");
//        System.out.println(customer);
//      
     
     Connection con = null;
     MyDataSource dataSource = (MyDataSource) context.getBean("myDataSource");
     try {
   con = dataSource.getConnection();
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
     
     
     DbUtils dbUtils = (DbUtils) context.getBean("dbUtils");
     dbUtils.setCon(con);
     
     List<Regions> rList = dbUtils.getAll();
     for(Regions r:rList)
      System.out.println(r.getRname() + " " + r.getRid());
     
     //add Region
     Regions reg=dbUtils.addRegion(new Regions(131,"India"));
     System.out.println(reg);
     
     Regions reg1=dbUtils.updateRegions(new Regions(130,"Bharath"));
     System.out.println(reg1);
     
     dbUtils.deleteRegion(128);
    
     
     
     
     }
}