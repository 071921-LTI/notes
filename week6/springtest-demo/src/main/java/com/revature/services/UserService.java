package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {

	List<User> getUsers();
	User getUserById(int id);
	User createUser(User user);
	
}
