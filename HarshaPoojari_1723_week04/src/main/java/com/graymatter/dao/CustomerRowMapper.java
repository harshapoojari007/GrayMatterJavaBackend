package com.graymatter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.graymatter.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
		}

	}


