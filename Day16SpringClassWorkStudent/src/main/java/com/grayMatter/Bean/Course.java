package com.grayMatter.Bean;

public class Course {
private int id;
private String name;
@Override
public String toString() {
	return "Course [id=" + id + ", Name=" + name + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Course() {
	super();
}
public Course(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
}
