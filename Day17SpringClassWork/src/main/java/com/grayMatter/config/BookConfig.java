package com.grayMatter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.grayMatter.Beans.Author;
import com.grayMatter.Beans.Book;

@Configuration
//It's a configuration file where we get all the annotaitons from the bean


@ComponentScan("com.grayMatter.Beans")
public class BookConfig {

	
	//1. Define beans
	//2. Supply values to beans properties
    //@Bean
	public Book myBook() {
		return new Book("Life on a Hell","LH112",400,getAuthor());
		
	}
    
    //@Bean(name="author")
    public Author getAuthor() {
    	return new Author("Harsha",123);
    }
}
