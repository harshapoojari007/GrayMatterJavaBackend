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
import lombok.ToString;

@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Author {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private List<Book> books=new ArrayList<>(); 
	
	public Author(String name) {
		this.name=name;
	}
	
	public Book addBook(Book book) {
		books.add(book);
		book.setAuthor(this);
		return book;
	}
	
	public void removeBook(Book book) {
		books.remove(book);
		book.setAuthor(null);
	}
	public void updateBook(int id,String name) {
		for(Book b:books) {
			if(b.getId()==id) {
				b.setTitle(name);
			}
		}
	}
	
	
	

}
