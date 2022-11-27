package com.cmg.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmg.authenticationservice.dto.AuthRequest;
import com.cmg.authenticationservice.dto.AuthResponse;
import com.cmg.authenticationservice.service.AuthService;
import com.cmg.authenticationservice.util.JWTUtil;

@RestController
public class AuthenticationController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/")
	public String home() {
		  return "Welcome to Daily Code Buffer!!";
	}
	
	@PostMapping("/authenticate")
	public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception{
		System.out.println("hare");
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
					authRequest.getPassword()));

		}
		catch (BadCredentialsException e) {
			System.out.println(e.getMessage());
		}
		
		final UserDetails details=authService.loadUserByUsername(authRequest.getUsername());
		final String token=jwtUtil.generateToken(details);
		System.out.println(token);
		
		return new AuthResponse(token);
	}
}
