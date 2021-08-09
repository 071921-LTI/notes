package com.revature.services;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserServiceImpl implements UserService{

	UserDao ud = new UserPostgres();
	
	@Override
	public boolean addUser(User user) {
		if(ud.addUser(user) == -1) {
		return false;
		} else {
			return true;
		}
	}

	@Override
	public List<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		User user = null;
		user = ud.getUserById(id);
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
