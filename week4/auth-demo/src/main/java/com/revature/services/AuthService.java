package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface AuthService {

	User login(String username, String password) throws UserNotFoundException;
	boolean authorize(String token) throws UserNotFoundException;
}
