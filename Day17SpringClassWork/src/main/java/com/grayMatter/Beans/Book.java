package com.grayMatter.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class Book {

//@Value("Work Like Hell and Advertise")
	@Value("${Book.bookName}")
private String bookName;

//@Value("WLHAA112")
@Value("${Book.isbnNum}")
private String isbnNum;

//@Value("1234")
@Value("${Book.price}")
private double price;
@Autowired
private Author author;

}
