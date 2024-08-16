package com.graymatter.dto;

import org.springframework.stereotype.Component;

import com.graymatter.entities.Item;

@Component
public class ItemMapper {

	public Item mapToItem(ItemDto itemDto) {
		return new Item(itemDto.getItemId() ,itemDto.getName(),itemDto.getCost(),itemDto.getOrders());
	}
	
	public ItemDto mapToItemDto(Item item) {
		return new ItemDto(item.getItemId() ,item.getName(),item.getCost(),item.getOrders());
	}
}
