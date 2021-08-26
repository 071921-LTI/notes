package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.Credentials;
import com.revature.models.User;

@Service
public class AuthService {

	private UserService us;

	@Autowired
	public AuthService(UserService us) {
		super();
		this.us = us;
	}
	
	public String login(Credentials creds) {
		User user = us.getUserByUsername(creds.getUsername());
		
		if(user == null || !user.getPassword().equals(creds.getPassword())) {
			return null;
		}
		
		return user.getId()+":"+user.getRole().toString();
	}
}
