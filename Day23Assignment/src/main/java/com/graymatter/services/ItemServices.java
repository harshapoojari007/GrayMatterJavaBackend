package com.graymatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.ItemDao;
import com.graymatter.dto.ItemDto;
import com.graymatter.dto.ItemMapper;
import com.graymatter.entities.Item;
import com.graymatter.exceptions.ResourceNotFoundException;

@Service
public class ItemServices implements ItemServiceInterface{

	@Autowired
	ItemDao dao;
	
	@Autowired
	ItemMapper mapper;
	
	public List<ItemDto> getAllItems() {
		List<Item> iList=dao.getAllItems(); 
		return iList.stream().map((item)->mapper.mapToItemDto(item)).collect(Collectors.toList());
	}

	public ItemDto addItem(ItemDto item) {
		// TODO Auto-generated method stub
		return mapper.mapToItemDto(dao.addItem(mapper.mapToItem(item)));
	}

	public ItemDto getItem(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return mapper.mapToItemDto(dao.getItem(id));
	}

	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		dao.deleteItem(id);
		
	}

}
