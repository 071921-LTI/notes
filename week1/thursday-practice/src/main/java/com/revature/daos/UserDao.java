package com.revature.daos;

import com.revature.models.User;

public interface UserDao {
	public abstract User getUser(String username);
	public abstract boolean addUser(User user);
}
