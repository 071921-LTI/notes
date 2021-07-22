package com.revature.services;

import com.revature.daos.UserCollection;
import com.revature.daos.UserDao;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserServiceImpl implements UserService {

	private UserDao ud = new UserCollection();
	
	@Override
	public boolean addUser(User user) {
		return false;
	}

	@Override
	public User getUser(String username) throws UserNotFoundException {
		return ud.getUser(username);
	}

}
