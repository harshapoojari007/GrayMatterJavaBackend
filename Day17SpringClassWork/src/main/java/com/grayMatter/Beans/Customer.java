package com.grayMatter.Beans;

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
public class Customer {
private int id;
private String mobile;
private String email;
private Order order;
}
