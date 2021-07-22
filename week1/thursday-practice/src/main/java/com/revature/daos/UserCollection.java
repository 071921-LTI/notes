package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserCollection implements UserDao{

	private static List<User> users;
	
	public UserCollection(){
		users = new ArrayList<>();
		users.add(new User("Bob", "Bob pass"));
		users.add(new User("Jenkins", "Jenkins pass"));
	}

	@Override
	public User getUser(String username) throws UserNotFoundException{
		for(User u: users) {
			if(username.equals(u.getUsername())) {
				return u;
			}
		}
		throw new UserNotFoundException();
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
