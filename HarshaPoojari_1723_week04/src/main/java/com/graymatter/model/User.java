package com.graymatter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class User {
		//Properties
		private String username;
		private String email;
		private String password;
		private String role;
	
}
