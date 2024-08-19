package com.graymatter.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
	@JsonIgnore
	private List<Item> items;
}
