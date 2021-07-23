package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserFile;
import com.revature.exceptions.AuthException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class AuthServiceImpl implements AuthService{
	
	private UserDao ud = new UserFile();
	
	// With this implementation AuthException isn't needed
	@Override
	public boolean login(User user) throws AuthException {
		/*
		 * Compare incoming user info with user info persisted
		 */
		try {
			User persistedUser = ud.getUser(user.getUsername());
			if(persistedUser.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
