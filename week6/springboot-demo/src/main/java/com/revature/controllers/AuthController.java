package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Credentials;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private AuthService as;
	
	
	public AuthController(AuthService as) {
		super();
		this.as = as;
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@Valid @RequestBody Credentials creds){
		String token = as.login(creds);
		if(token == null) {
			return new ResponseEntity<>("Invalid attempt.", HttpStatus.UNAUTHORIZED);
		}
		HttpHeaders hh = new HttpHeaders();
		hh.set("Authorization", token);
		return new ResponseEntity<>(hh, HttpStatus.OK);
	}
}
