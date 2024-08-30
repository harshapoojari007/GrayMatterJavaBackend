package com.graymatter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.entities.User;
import com.graymatter.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;
	
	public List<User> getAllUsers(){
		return repo.findAll();
		
	}
	
	
	

}
