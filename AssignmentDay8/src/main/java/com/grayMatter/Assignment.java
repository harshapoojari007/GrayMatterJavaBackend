package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Loaded");
	
	String url="jdbc:mysql://localhost:3306/graymatterdb";
	String username="root";
	String password="password";
	
	Connection con=DriverManager.getConnection(url,username,password);
	
	boolean ch=true;
	do {
		System.out.println("1. Insert\n2. Update\n3. Select\n4. Delete\n5. Exit");
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		switch(c) {
		case 1:
			String iQuery="Insert into regions values(?,?)";
			PreparedStatement ins=con.prepareStatement(iQuery);
			System.out.print("Enter Region Id:");
			int id=sc.nextInt();
			System.out.println("Enter Region Name:");
			String name=sc.next();
			ins.setInt(1, id);
			ins.setString(2, name);
			ins.executeUpdate();
			System.out.println("Successfully Inserted Values");
			break;
		case 2:
			String query="update regions set region_name=? where region_id=?";
		     PreparedStatement ps=con.prepareStatement(query);
		     System.out.print("Enter Region Id To be Updated:");
			 int uid=sc.nextInt();
			 System.out.println("Enter Region Name To be Added:");
			 String uname=sc.next();
		     ps.setString(1, uname);
		     ps.setInt(2, uid);
		     ps.executeUpdate();
		     System.out.println("Successfully Updated");
		     break;
		case 4:
			query ="delete from regions where region_id=?";
	        	ps=con.prepareStatement(query);
	        	ps.setInt(1,7);
	        	ps.executeUpdate();

               System.out.println("row deleted successfully");
               break;
		case 3:	
			 Statement st1=con.createStatement();
			 String query3= "Select * from regions";
		       ResultSet rs1= st1.executeQuery(query3);
		     System.out.println("Region Id   Region_Name");
			 while(rs1.next()) {
			 System.out.println(rs1.getInt(1)+"           "+rs1.getString(2));
			 }
			
            break;
		case 5:
			ch=false;break;
		default:
			System.out.println("Invalid CHoice");
		
		}
	
		
		

		
	}while(ch);
	
	
////	
////
////			
////
////			ps.setInt(1, 7);
////
////			
////

}
}
