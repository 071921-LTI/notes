package com.revature.controllers;

import java.util.List;

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
public class UserControllerImpl implements UserController {

	private UserService us;
	
	@Autowired
	public UserControllerImpl(UserService us) {
		super();
		this.us = us;
	}

	/*
	 * - should return all users
	 * - should have a status code of 200 (ok) 
	 */
	
	@GetMapping
	@Override
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(us.getUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@Override
	public ResponseEntity<User> getById(@PathVariable("id") int id) {
		return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);
	}

	/*
	 * if created
	 * 	status code 201
	 * 	new User
	 * 
	 */
	
	@PostMapping
	@Override
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(us.createUser(user), HttpStatus.CREATED);
	}

}
