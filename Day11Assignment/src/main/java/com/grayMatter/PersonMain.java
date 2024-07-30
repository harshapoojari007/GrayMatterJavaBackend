package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	PersonImplementation p=new PersonImplementation();
    Scanner sc=new Scanner(System.in);
    boolean ch=true;
    do {
    	
    	System.out.println("Persons MENU");
    	System.out.println("1. Get All Person Ino\n2. Add a Person\n3. Update the Person\n4. Delete the Person\n5. Get person by ID\n6. Exit");
    	System.out.print("Choose an option:");
    	int choice=sc.nextInt();
    	switch(choice) {
    	case 1:System.out.println( p.getAllPeronsInfo());break;
    	case 2:
    		   System.out.println("enter the person info");
    		   System.out.print("ID:");
    		   int id=sc.nextInt();
    		   System.out.print("NAME:");
    		   String name=sc.next();
    		   System.out.print("AGE:");
    		   int age=sc.nextInt();
    		   System.out.print("EMAIL:");
    		   String email=sc.next();
    		   Person p1=new Person(id,name,age,email);
    		   
    		   p.addPerson(p1);break;
    	case 3: System.out.println("enter the person info to be updated");
		        System.out.print("ID:");
		        int id1=sc.nextInt();
		        System.out.print("NAME:");
		        String name1=sc.next();
		        System.out.print("AGE:");
		        int age1=sc.nextInt();
		        System.out.print("EMAIL:");
		        String email1=sc.next();
		        Person p2=new Person(id1,name1,age1,email1);
    		    p.updatePerson(p2);break;
    	case 4:
    		   System.out.println("enter the person id to be deleted ");
 		       System.out.print("ID:");
 		       int idd=sc.nextInt();
    		   p.deletePerson(idd);break;
    	case 5:System.out.print("Enter thr ID:");
    	       int getId=sc.nextInt();
    	       System.out.println(p.getPersonById(getId));break;
    	case 6:ch=false;break;
    	default:System.out.println("Invalid Choice");
    	}
    	
    }while(ch);
	
	
	
}
}
