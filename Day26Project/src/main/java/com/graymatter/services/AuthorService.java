package com.graymatter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.entities.Author;
import com.graymatter.entities.Book;
import com.graymatter.repositories.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repo;
	
	public void saveAuthorWithBook() {
		Author a=new Author("Harsha");
		Book b1=new Book("How to Talk with Anyone");
		Book b2=new Book("10dulkar");
		a.addBook(b1);
		a.addBook(b2);
		repo.save(a);
		
		
	}
	
	@Transactional
	public void removeAuthor(int id) {
		repo.deleteById(id);
	}
}
