package com.revature.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.models.User;

public interface UserController {

	ResponseEntity<List<User>> getAll();
	ResponseEntity<User> getById(int id);
	ResponseEntity<User> createUser(User user);
}
