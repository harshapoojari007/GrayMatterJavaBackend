package com.grayMatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grayMatter.Beans.Customer;
import com.grayMatter.Beans.HelloBean;
import com.grayMatter.Beans.Order;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        HelloBean hb=new HelloBean();
//        hb.sayHello();
//        
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("hello-bean.xml");
    	HelloBean hb=(HelloBean) context.getBean("hello");// down casting
    	hb.sayHello();
    	
    	
    	HelloBean hb1=(HelloBean) context.getBean("hello");
    	hb1.sayHello();
    	
//    	
//    	Customer c=new Customer("Harsha",117,"890");
//    	System.out.println(c);
    	
    	ApplicationContext custContext=new ClassPathXmlApplicationContext("cutomer-bean.xml");
    	Customer c=(Customer)custContext.getBean("cust");
    	System.out.println(c);
    	
    	
    	
    	Customer ca=(Customer)custContext.getBean("cust");
    	System.out.println(ca.hashCode());
    	
    	Customer cb=(Customer)custContext.getBean("cust");
    	System.out.println(cb.hashCode());
    	
    	Customer cc=(Customer)custContext.getBean("cust");
    	System.out.println(cc.hashCode());
    	
    	
    	
    	Customer c1=(Customer)custContext.getBean("cust1");
    	System.out.println(c1);
    	
    	
    	Order o=(Order)custContext.getBean("order");
    	System.out.println(o);
    	
    	Order o2=(Order)custContext.getBean("order1");
    	System.out.println(o2);
    	
    	
    	
    	
    	
        
    }
}
