package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.PostDao;
import com.graymatter.model.Post;

@Service
public class PostService {

	@Autowired
	private  PostDao post;
	
	public int addPost(Post p) {
	return	post.addPost(p);
	
	}
	public int deletePost(int id) {
		return	post.deletePost(id);
		
		}
	public int updatePost(Post p) {
		return	post.updatePOst(p);
		
		}
	public Post getPostById(int id) {
		return	post.getById(id);
		
		}
	public List<Post> getAllPost() {
		return	post.getAll();
		
		}
	
}
