package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Item;
import com.graymatter.exceptions.ResourceNotFoundException;
import com.graymatter.repositories.ItemRespository;

@Repository
public class ItemDao {

	@Autowired
	ItemRespository repo;
	
	public List<Item> getAllItems(){
		return repo.findAll();
	}

	public Item addItem(Item item){
		// TODO Auto-generated method stub
		return repo.save(item);
	}

	public Item getItem(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
}
