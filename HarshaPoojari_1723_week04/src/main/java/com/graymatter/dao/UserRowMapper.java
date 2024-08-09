package com.graymatter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.graymatter.model.User;


public class UserRowMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
	}
}
