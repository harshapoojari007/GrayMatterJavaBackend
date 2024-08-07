package com.grayMatter.Bean;

import java.util.List;
import java.util.Set;

public class Student {
private int id;
private String name;
private String blood;
private Set<Course> courses;
public void setCourses(Set<Course> courses) {
	this.courses = courses;
}


public Student(int id, String name, String blood, Set<Course> courses) {
	super();
	this.id = id;
	this.name = name;
	this.blood = blood;
	this.courses = courses;
}

public Set<Course> getCourses() {
	return courses;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", blood=" + blood + ", courses=" + courses + "]";
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
public String getBlood() {
	return blood;
}
public void setBlood(String blood) {
	this.blood = blood;
}
public Student() {
	super();
}
public Student(int id, String name, String blood) {
	super();
	this.id = id;
	this.name = name;
	this.blood = blood;
}

}