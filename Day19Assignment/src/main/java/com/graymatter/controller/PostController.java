package com.graymatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Post;
import com.graymatter.service.PostService;

@Controller
public class PostController {
	
	
	
	@Autowired
	private PostService service;
	
	//Workings
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username,@RequestParam String password) {
		ModelAndView mv=null;
		if(username.equals("admin") && password.equals("12345"))
		{
			mv=new ModelAndView("PostDashboard");
			mv.addObject("username", username);
			
			return mv;
			
		}
		mv=new ModelAndView("login");
		mv.addObject("error","Invalid Credentials");
		return mv;
			
	}
	@RequestMapping("/addPost")
	public ModelAndView addPost(@RequestParam String title, @RequestParam String id, @RequestParam String content, @RequestParam String author) {
		int i=service.addPost(new Post(Integer.parseInt(id),title,content,author));
		ModelAndView mv=new ModelAndView("PostDashboard");
		mv.addObject("message","Successfully Added Post");
		return mv;
	}
	@RequestMapping("/deletePost")
	public ModelAndView deletePost(@RequestParam String id) {
		int i=service.deletePost(Integer.parseInt(id));
		ModelAndView mv=new ModelAndView("PostDashboard");
		mv.addObject("message","Successfully Deleted Post");
		return mv;
	}
	@RequestMapping("/updatePost")
	public ModelAndView updatePost(@RequestParam String title, @RequestParam String id, @RequestParam String content, @RequestParam String author) {
		int i=service.updatePost(new Post(Integer.parseInt(id),title,content,author));
		ModelAndView mv=new ModelAndView("PostDashboard");
		mv.addObject("message","Successfully Updated Post");
		return mv;
	}
	@RequestMapping("/getPost")
	public ModelAndView getPost(@RequestParam String id) {
		Post p=service.getPostById(Integer.parseInt(id));
		ModelAndView mv=new ModelAndView("Display");
		mv.addObject("post",p);
		return mv;
	}
	@RequestMapping("/getAll")
	public ModelAndView getALlPost() {
		List<Post> postList=service.getAllPost();
		ModelAndView mv=new ModelAndView("Display");
		mv.addObject("postList",postList);
		mv.addObject("action","All");
		return mv;
	}
	
	
	//Page Rendering
	@RequestMapping("/dologin")
	public ModelAndView dologin() {
		return new ModelAndView("login");
	}
	@RequestMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("addPost");
	}
	@RequestMapping("/delete")
	public ModelAndView delete() {
		return new ModelAndView("deletePost");
	}
	@RequestMapping("/update")
	public ModelAndView update() {
		return new ModelAndView("updatePost");
	}
	@RequestMapping("/get")
	public ModelAndView getp() {
		return new ModelAndView("getPost");
	}
	
	
}
