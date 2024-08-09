package com.graymatter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.graymatter.model.Post;

public class PostRowMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Post(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
	}

}
