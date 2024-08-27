package com.graymatter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name="getByName",query="Select p from Person p where p.name=:name")
@NamedQuery(name="getByNameAndAge",query="Select p from Person p where p.name=:name and p.age=:age")
@NamedQuery(name="getByNameLAndAge25",query="Select p from Person p where p.name LIKE 'l%' and p.age=25")
public class Person {
	@Id
	private int id;
	private String name;
	private int age;
}
