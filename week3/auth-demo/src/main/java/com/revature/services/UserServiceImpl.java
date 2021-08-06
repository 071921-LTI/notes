package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserServiceImpl implements UserService{
	
	private UserDao ud = new UserPostgres();

	@Override
	public boolean addUser(User user) {
		int id = ud.addUser(user);
		if (id == 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		return ud.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {
		return ud.getUserByUsername(username);
	}

	@Override
	public boolean deleteUser(int id) throws UserNotFoundException {
		if (ud.deleteUser(id) == 1) {
			return true;
		}
		return false;
	}

}
