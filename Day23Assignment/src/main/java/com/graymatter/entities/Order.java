package com.graymatter.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="projectOrder")
public class Order {	
	@Id
	private int orderId;
	private Date date;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="orderId"),
	           inverseJoinColumns = @JoinColumn(name="itemId")
		        
	)
	private List<Item> items;
}
