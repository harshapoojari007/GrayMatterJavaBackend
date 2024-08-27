package com.graymatter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.graymatter.configurations.UserPrinciple;
import com.graymatter.entities.User;
import com.graymatter.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= repo.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException(username);
		else
			return new UserPrinciple(user);
	}
	


	
}
