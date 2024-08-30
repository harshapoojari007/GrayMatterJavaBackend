package com.graymatter.dtos;

import com.graymatter.entities.User;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String username;
	private String email;
	private String password;
}
