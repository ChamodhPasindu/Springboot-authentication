package com.cmg.authenticationservice.Filter;

import java.io.IOException;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cmg.authenticationservice.service.AuthService;
import com.cmg.authenticationservice.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService authService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		 String authorization = httpServletRequest.getHeader("Authorization");
	        String token = null;
	        String userName = null;

	        if(null != authorization && authorization.startsWith("Bearer ")) {
	            token = authorization.substring(7);
	            userName = jwtUtil.getUsernameFromToken(token);
	        }

	        if(null != userName && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails
	                    = authService.loadUserByUsername(userName);

	            if(jwtUtil.validateToken(token,userDetails)) {
	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
	                        = new UsernamePasswordAuthenticationToken(userDetails,
	                        null, userDetails.getAuthorities());

	                usernamePasswordAuthenticationToken.setDetails(
	                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
	                );

	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }

	        }
	        filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
	
	
}
