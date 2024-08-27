package com.graymatter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
}
