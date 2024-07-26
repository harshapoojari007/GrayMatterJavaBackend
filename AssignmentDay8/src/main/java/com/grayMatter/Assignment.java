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
		System.out.println("1. Update\n2. Select\n3. Delete\n4. Exit");
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		switch(c) {
		case 1:String query="update regions set region_name=? where region_id=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, "Karnataka");
		ps.setInt(2, 7);
		ps.executeUpdate();
		
		Statement st=con.createStatement();
		String query1="select * from regions";
		ResultSet rs=st.executeQuery(query1);
		System.out.println("Updated");
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		
		}
		
	}while(ch);
	
	
//	query ="delete from regions where region_id=?";
//
//			ps=con.prepareStatement(query);
//
//			ps.setInt(1, 7);
//
//			ps.executeUpdate();
//
//			System.out.println("row deleted");
//
//			String query3= "Select * from regions";
//
//			ResultSet rs1= st.executeQuery(query3);
//
//			while(rs1.next()) {
//
//				 System.out.println(rs1.getInt(1)+" "+rs1.getString(2));
//
//			}
//	
//	ps.close();
//	st.close();
//	rs.close();
//	
	

}
}
