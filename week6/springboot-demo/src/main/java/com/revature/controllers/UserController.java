package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Secured;
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

	@Secured(allowedRoles= {"ADMIN", "BASIC_USER"})
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<>(us.getAll(), HttpStatus.OK);
	}
	
	@Secured(allowedRoles= {"ADMIN", "BASIC_USER"})
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getById(@PathVariable("id") int id){
		return new ResponseEntity<User>(us.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@Valid @RequestBody User user, @RequestHeader String header){
		//Do something with my headers
		User u = us.createUser(user);
		return new ResponseEntity<>("User "+ u.getUsername() + "has been created.", HttpStatus.CREATED);
	}
	
	@Secured(allowedRoles= {"ADMIN", "BASIC_USER"})
	@PutMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable("id") int id){
		return new ResponseEntity<>(us.updateUser(id, user), HttpStatus.CREATED);
	}
	
	@Secured(allowedRoles= {"ADMIN"})
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable("id") int id){
		us.deleteUser(id);
		return new ResponseEntity<>("User was deleted", HttpStatus.OK);
	}
}
