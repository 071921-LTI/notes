package com.revature.daos;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserDao {

	// if no user is found
	User getUserById(int id) throws UserNotFoundException;
	// if no user is found
	User getUserByUsername(String username) throws UserNotFoundException;
	List<User> getUsers();
	// Should return the id generated
	int addUser(User user);
	// if no user is found
	int deleteUser(int id) throws UserNotFoundException;
	/*
	 * could do update user
	 */
}
