package com.grayMatter.Beans;

import org.springframework.beans.factory.annotation.Value;

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
public class Department {
@Value("${Department.deptId}")
private String deptName;
@Value("${Department.deptId}")
private int deptId;

}
