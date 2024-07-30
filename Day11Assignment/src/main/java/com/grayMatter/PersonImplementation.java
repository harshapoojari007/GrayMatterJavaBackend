package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonImplementation implements PersonInterface{
	@Override
	public Person getPersonById(int id) throws ClassNotFoundException, SQLException {
		 DriverClass dc=new DriverClass();
		    Connection con=dc.getCOnnection();
		    
		    String query1= "select * from person where id=?";
			PreparedStatement ps1= con.prepareStatement(query1);
			ps1.setInt(1, id);
			ResultSet rs= ps1.executeQuery();
			Person p=null;
			while(rs.next()) {
				p=new Person(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
			return p;
	}

	@Override
	public Person addPerson(Person person) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DriverClass dc=new DriverClass();
		Connection con=dc.getCOnnection();
		    
		String query= "insert into person values(?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(2,person.getName());
		ps.setInt(3,person.getAge());
		ps.setString(4,person.getEmail());
		ps.setInt(1,person.getId());
		int rowsAffected=ps.executeUpdate();
		System.out.println("Sucessfully Added");
		System.out.println("Rows affected:"+rowsAffected);
		
		return person;
		}

	@Override
	public Person updatePerson(Person person) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DriverClass dc=new DriverClass();
		Connection con=dc.getCOnnection();
		    
		String query= "update person SET name=?,age=?,email=? where id=?";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(1,person.getName());
		ps.setInt(2,person.getAge());
		ps.setString(3,person.getEmail());
		ps.setInt(4,person.getId());
		int rowsAffected=ps.executeUpdate();
		System.out.println("Sucessfully Updated");
		System.out.println("Rows affected:"+rowsAffected);
		return person;
	}

	@Override
	public Person deletePerson(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        DriverClass dc=new DriverClass();
	    Connection con=dc.getCOnnection();
	    
	    String query1= "select * from person where id=?";
		PreparedStatement ps1= con.prepareStatement(query1);
		ps1.setInt(1, id);
		ResultSet rs= ps1.executeQuery();
		Person p=null;
		while(rs.next()) {
			p=new Person(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
		}
	    
		String query= "delete from person where id=?";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Successfully Deleted");
		return p;
	}

	@Override
	public List<Person> getAllPeronsInfo() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	        DriverClass dc=new DriverClass();
		    Connection con=dc.getCOnnection();
			String query= "Select * from person";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			List <Person> personList= new ArrayList<>();
			while(rs.next()) {
				personList.add(new Person(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			return personList;
		}
	}


