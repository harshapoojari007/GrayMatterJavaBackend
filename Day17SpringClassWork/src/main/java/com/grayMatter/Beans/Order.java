package com.grayMatter.Beans;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
@PropertySource("classpath:data.properties")
public class Order {
private int id;
private String order_date;
private List<Item> item;

}
