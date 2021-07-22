package com.revature.services;

import com.revature.models.User;

public interface UserService {

	// does this user already exist?
	public abstract boolean addUser(User user);
	public abstract User getUser(String username);
	
}
