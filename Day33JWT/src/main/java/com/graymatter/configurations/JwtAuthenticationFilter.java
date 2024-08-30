package com.graymatter.configurations;

import java.io.IOException;


//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.graymatter.exceptions.HandlerExceptions;
import com.graymatter.services.JwtService;
import com.graymatter.services.MyUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtService jwtService;
	
	@Autowired 
	 MyUserDetailService userDetailService;
	
	@Autowired
	HandlerExceptions handlerExceptions;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader=request.getHeader("Authorization");
		
		if(authHeader==null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		String token=authHeader.substring(7);
		String email=jwtService.extractUsername(token);

		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(email!=null && authentication==null) {
			UserDetails userDetails=userDetailService.loadUserByUsername(email);
			
			if(jwtService.isTokenValid(token,userDetails)) {
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
				
			}
		}
		
		filterChain.doFilter(request, response);
		
		
		
		
		
		
		
	}

}
