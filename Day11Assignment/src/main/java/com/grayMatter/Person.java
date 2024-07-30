package com.grayMatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
private int id;
private String name;
private int age;
private String email;
public Person getPeron(Person p) {
	return p;
}
}
