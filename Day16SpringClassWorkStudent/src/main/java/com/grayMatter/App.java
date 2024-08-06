package com.grayMatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grayMatter.Bean.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext ac=new  ClassPathXmlApplicationContext("Student-Bean.xml");
      
       Student st=(Student) ac.getBean("stu2");
       System.out.println(st);
//       Student st1=(Student)ac.getBean("stu1");
//       System.out.println(st1);
       
    }
}
