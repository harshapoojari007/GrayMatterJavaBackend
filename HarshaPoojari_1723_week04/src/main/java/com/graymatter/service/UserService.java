package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.UserDao;
import com.graymatter.model.User;



@Service
public class UserService {

	@Autowired
	private UserDao user;
	
	//ADD SERVICE
	public int addUser(User u) {
		return	user.addUser(u);
		
		}
	
	//GET SERVICE
		public List<User> getUser(String  username,String password) {
			return	user.getUser(username, password);
			
		}
}
