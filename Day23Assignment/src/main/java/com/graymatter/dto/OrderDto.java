package com.graymatter.dto;

import java.sql.Date;
import java.util.List;

import com.graymatter.entities.Item;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private int orderId;
	private Date date;
	private List<Item> items;
}
