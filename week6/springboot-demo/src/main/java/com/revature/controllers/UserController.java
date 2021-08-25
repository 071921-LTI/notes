package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService us;
	
	@Autowired
	public UserController(UserService us) {
		super();
		this.us = us;
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") int id){
		return new ResponseEntity<User>(us.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody User user){
		if(us.getUserByUsername(user.getUsername())!= null) {
			return new ResponseEntity<>("Username is use.", HttpStatus.BAD_REQUEST);
		}
		int newUserId = us.createUser(user);
		return new ResponseEntity<>("User "+ user.getUsername() + " with id of " + newUserId + "has been created.", HttpStatus.CREATED);
	}
}
