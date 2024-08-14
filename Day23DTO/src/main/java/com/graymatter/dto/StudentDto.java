package com.graymatter.dto;

import com.graymatter.entities.Student;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto{
private String name;
private int id;
}
