package com.graymatter;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.graymatter.dao.EmployeeDao;
import com.graymatter.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-bean.xml");
        EmployeeDao dao=(EmployeeDao)context.getBean("empdao");
        int i=dao.addEmployee(new Employee("Harsha",119,1000000));
        System.out.println("Row inserted Successfully");
        
        
        List<Employee> empList=dao.getAllEMployee();
        for(Employee emp:empList)
        	System.out.println(emp);
        
        dao.updateEmployee(new Employee("Harsha Poojari",111,1000));
        System.out.println("row updated succerssfully");
        
        System.out.println("After Update");
        empList=dao.getAllEMployee();
        for(Employee emp:empList)
        	System.out.println(emp);
        
        dao.deleteEmployee(115);
        System.out.println("row deleted succerssfully");
        
        System.out.println("After Delete");
        empList=dao.getAllEMployee();
        for(Employee emp:empList)
        	System.out.println(emp);
        
        System.out.println("Employee id =111");
        Employee emp1=dao.getEmployee(111);
        	System.out.println(emp1);
        
        
        
        
        
        
        
    }
}
