package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.graymatter.model.User;


@Component
public class UserDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Authentication
	
	
	//LOGIN UP
	public List<User> getUser(String username,String password) {
		String query="select * from user where username='"+username+"' AND password='"+password+"';";
		List<User> ul=jdbcTemplate.query(query, new UserRowMapper());
		return ul;
	}
	
	//SIGN UP
	public int addUser(User u) {
		try {
			String query="insert into user values('"+u.getUsername()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getRole()+"');";
			int i=jdbcTemplate.update(query);
			return i;
		}catch(Exception e) {
			return 0;
		}
		
	}
	
	
}
