package com.grayMatter.Beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

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
@Component
@PropertySource("classpath:data.properties")

public class Author {
	
//@Value("Harsha")
	@Value("${Author.authorName}")
private  String authorName;

//@Value("1723")
@Value("${Author.authorId}")
private int authorId;
}
