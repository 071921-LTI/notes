package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.models.UserRole;

@Service
public class UserService {
	
	private List<User> users = new ArrayList<>();
	
	public UserService () {
		users.add(new User(1, "Kevin", "KevPass", UserRole.ADMIN));
		users.add(new User(2, "Bob", "BobPass", UserRole.BASIC_USER));
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUserById(int id) {
		for(User u: users) {
			if(u.getId() == id) {
				return u;
			}
		}
		
		throw new UserNotFoundException();
	}
	
	public User getUserByUsername(String username) {
		for(User u: users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		
		throw new UserNotFoundException();
	}
	
	public void createUser(User u) {
		users.add(u);
	}
	
	public List<User> getUsersByRole(UserRole ur){
		List<User> temp = new ArrayList<>();
		for(User u : users) {
			if(u.getUserRole().equals(ur)) {
				temp.add(u);
			}
		}
		return temp;
	}
}
