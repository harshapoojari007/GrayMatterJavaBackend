package com.graymatter.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Order { 

 

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Long id; 

 

    private String customerName; 

 

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, orphanRemoval = true) 

    private List<OrderItem> orderItems = new ArrayList()<>(); 

 

    // Constructors, Getters, and Setters 

 

    public Order() {} 

 

    public Order(String customerName) { 

        this.customerName = customerName; 

    } 

 

    public void addOrderItem(OrderItem item) { 

        orderItems.add(item); 

        item.setOrder(this); 

    } 
}
