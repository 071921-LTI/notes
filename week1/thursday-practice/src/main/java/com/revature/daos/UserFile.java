package com.revature.daos;

import java.io.File;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserFile implements UserDao {

	File userFile = new File("src/main/resources/users.txt");

	@Override
	public User getUser(String username) throws UserNotFoundException {
		return null;
	}

	@Override
	public boolean addUser(User user) {
		return false;
	}

}
