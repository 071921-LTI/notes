package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.services.UserService;

//@Controller
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	private UserService us;
	
	@Autowired
	public UserController(UserService us) {
		this.us=us;
	}
	
	/*
	 *  /users -> GET -> all users in Response body
	 *  /users/{id} -> GET  -> return user with that id
	 *  					-> return 404 with exception
	 *  /users?username=value -> GET -> return user with that username
	 *  							 -> return 404 with exception
	 *  
	 *  /users -> POST -> create a new user
	 *  				
	 *  
	 */
	
	@RequestMapping(method=RequestMethod.GET)
//	@ResponseBody
	public List<User> getAllUsers(@RequestParam(name="userRole", required = false)UserRole userRole){
		if(userRole != null) {
			return us.getUsersByRole(userRole);
		}
		return us.getUsers();
	}
	
//	@GetMapping("/{id}")
//	@ResponseBody
//	public User getUserById(@PathVariable("id") int id) {
//		return us.getUserById(id);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);
	}
	
//	@PostMapping
//	public String createUser(@RequestBody User u) {
//		us.createUser(u);
//		return "added " + u.getUsername();
//	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User u) {
		us.createUser(u);
		return new ResponseEntity<>("added user " + u.getUsername(), HttpStatus.CREATED);
	}
}
