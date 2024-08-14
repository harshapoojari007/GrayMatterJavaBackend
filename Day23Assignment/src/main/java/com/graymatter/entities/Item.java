package com.graymatter.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="projectItem")
public class Item {

	@Id
	private int itemId;
	private String name;
	private double cost;
	@ManyToMany(mappedBy = "items")
	List<Order> orders;
}
