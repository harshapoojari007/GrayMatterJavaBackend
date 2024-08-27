package com.graymatter.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurtiyConfiguraion{

	@Autowired
	UserDetailsService service;
	
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
//	public void myConfiguration(HttpSecurity http) throws Exception{
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/login")
//		.permitAll()
//		.anyRequest()
//		.authenticated().and()
//		.formLogin().loginPage("/login").permitAll();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.anyRequest()
		.authenticated().and()
		.oauth2Login();
		return http.build();
		
//		
//		 http
//         .authorizeRequests(authorizeRequests ->
//             authorizeRequests
//                 .requestMatchers("/public/**").permitAll() // Allow access to /public endpoints without authentication
//                 .anyRequest().authenticated() // Require authentication for all other requests
//         )
//         .formLogin(formLogin ->
//             formLogin
//                 .loginPage("/login") // Specify the custom login page URL
//                 .permitAll() // Allow all users to access the login page
//         )
//         .logout(logout ->
//             logout
//                 .permitAll() // Allow all users to access the logout functionality
//         )
//         .httpBasic(); 
//		return http.build();
	}
	
}
