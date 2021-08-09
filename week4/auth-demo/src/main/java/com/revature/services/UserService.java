package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserService {

	// Should return true if a user was successfully added
	boolean addUser(User user);
	List<User> getUsers();
	User getUserById(int id) throws UserNotFoundException;
	User getUserByUsername(String username);
	// Should return true if a user was successfully added
	boolean deleteUser(int id);
	
}
