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
	public User getUser(String username) {
		String query="select * from user where username='"+username+"';";
		List<User> ul=jdbcTemplate.query(query, new UserRowMapper());
		return ul.get(0);
	}
	
	//SIGN UP
	public User addUser(User u) {
		String query="insert into user values('"+u.getUsername()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getRole()+"');";
		List<User> ul=jdbcTemplate.query(query, new UserRowMapper());
		return ul.get(0);
	}
	
	
}
