package com.graymatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entities.Item;

public interface ItemRespository extends JpaRepository<Item, Integer>{
	

}
