package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserFile;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserServiceImpl implements UserService {

	private UserDao ud = new UserFile();
	
	@Override
	public boolean addUser(User user) {
		//Maybe have some additional business logic here
		return ud.addUser(user);
	}

	@Override
	public User getUser(String username) throws UserNotFoundException {
		return ud.getUser(username);
	}

}
