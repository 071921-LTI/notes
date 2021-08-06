package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {

	// Should return true if a user was successfully added
	boolean addUser(User user);
	List<User> getUsers();
	User getUserById();
	User getUserByUsername();
	// Should return true if a user was successfully added
	boolean deleteUser(int id);
	
}
