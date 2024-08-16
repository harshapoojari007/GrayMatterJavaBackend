package com.graymatter.dto;

import java.util.List;

import com.graymatter.entities.Item;
import com.graymatter.entities.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {

	private int itemId;
	private String name;
	private double cost;
	List<Order> orders;
}
