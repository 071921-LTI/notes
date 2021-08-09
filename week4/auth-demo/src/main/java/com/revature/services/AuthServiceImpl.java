package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class AuthServiceImpl implements AuthService {

	UserDao ud = new UserPostgres();

	@Override
	public User login(String username, String password) throws UserNotFoundException {
		User user = ud.getUserByUsername(username);
		if (user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public boolean authorize(String token) throws UserNotFoundException {
	String[] stringArr = token.split(":");
	int id = Integer.parseInt(stringArr[0]);
	String role = stringArr[1];
		User user = ud.getUserById(id);
		if(!user.getRole().equals(role)) {
			return false;
		} else {
			return true;
		}
	}
}
