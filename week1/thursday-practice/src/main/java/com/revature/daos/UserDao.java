package com.revature.daos;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserDao {
	public abstract User getUser(String username) throws UserNotFoundException;
	public abstract boolean addUser(User user);
}
