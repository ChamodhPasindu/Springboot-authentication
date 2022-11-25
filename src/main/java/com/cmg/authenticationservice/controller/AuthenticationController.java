package com.cmg.authenticationservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth/v2")
@CrossOrigin
public class AuthenticationController {
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public void getAllCustomer() {
		System.out.println("helow");
	}

}
