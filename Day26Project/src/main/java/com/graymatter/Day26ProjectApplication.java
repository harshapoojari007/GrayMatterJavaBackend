package com.graymatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.graymatter.services.AuthorService;

@SpringBootApplication
public class Day26ProjectApplication implements CommandLineRunner{
	
	@Autowired
	AuthorService service;

	public static void main(String[] args) {
		SpringApplication.run(Day26ProjectApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) {
		//service.saveAuthorWithBook();
		service.removeAuthor(1);
		
		
	}

}
