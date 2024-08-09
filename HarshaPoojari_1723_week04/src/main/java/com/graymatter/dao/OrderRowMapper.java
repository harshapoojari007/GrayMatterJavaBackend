package com.graymatter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.graymatter.model.Customer;
import com.graymatter.model.Order;

public class OrderRowMapper implements RowMapper<Order>{
	
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Order(rs.getInt(1),rs.getDate(2),rs.getDouble(3),rs.getInt(4));
	}
}
