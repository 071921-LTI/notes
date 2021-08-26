package com.revature.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserRepository;
import com.revature.exceptions.InvalidUsernameException;
import com.revature.exceptions.UserAlreadyExistsException;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.User;
import com.revature.models.UserRole;

@Service
public class UserService {

	private UserRepository ur;

	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	

	public User getUserById(int id) {
		return ur.findById(id).orElse(null);
	}
	

	public User getUserByUsername(String username) {
		if(username == null || username.equals("")) {
			throw new InvalidUsernameException();
		}
		return ur.findUserByUsername(username);
	}
	
	@Transactional
	public User createUser(User newUser) {
		if(getUserByUsername(newUser.getUsername()) != null) {
			throw new UserAlreadyExistsException();
		}
		
		newUser.setRole(UserRole.BASIC_USER);
		newUser.setRegisterDateTime(LocalDateTime.now());
		
		return ur.save(newUser);
	}
	

	public List<User> getAll(){
		return ur.findAll();
	}
	
	@Transactional
	public User updateUser(int id, User user) {
		if(getUserById(id) == null) {
			throw new UserDoesNotExistException();
		}
		
		User checkUsername = getUserByUsername(user.getUsername());
		
		if(checkUsername != null && checkUsername.getId() != id) {
			throw new UserAlreadyExistsException();
		}
		
		user.setId(id);
		
		return ur.save(user);
	}
	
	@Transactional
	public void deleteUser(int id) {
		if(getUserById(id) == null) {
			throw new UserDoesNotExistException();
		}
		ur.deleteById(id);
	}
}
