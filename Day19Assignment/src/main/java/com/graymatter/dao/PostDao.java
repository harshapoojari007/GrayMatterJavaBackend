package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graymatter.model.Post;

@Component
public class PostDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Operations
	
	
	//ADD
	public int addPost(Post p)
	{
		String query="insert into post values("+p.getId()+",'"+p.getTitle()+"','"+p.getContent()+"','"+p.getAuthor()+"');";
		int i=jdbcTemplate.update(query);
		return i;
	}
	
	//DELETE
	public int deletePost(int id) {
		String query="delete from post where id="+id;
		int i=jdbcTemplate.update(query);
		return i;
	}
	
	//UPDATE
	public int updatePOst(Post p) {
		String query="update  post set title='"+p.getTitle()+"',content='"+p.getContent()+"',author='"+p.getAuthor()+"' where id="+p.getId();
		int i=jdbcTemplate.update(query);
		return i;
	}
	
	//Get Single Blog
	public Post getById(int id) {
		String query="select * from post where id="+id;
		List<Post> pt=jdbcTemplate.query(query, new PostRowMapper());
		return pt.get(0);
	}
	//GetAl
	
	public List<Post> getAll(){
		String query="Select * from post";
		List<Post> pt=jdbcTemplate.query(query, new PostRowMapper());
		return pt;
	}
	
}
