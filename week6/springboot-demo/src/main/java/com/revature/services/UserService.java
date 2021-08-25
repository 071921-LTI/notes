package com.revature.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserRepository;
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
	
	@Transactional(readOnly=true)
	public User getUserById(int id) {
//		return ur.getById(id);
		return ur.findById(id).get();
	}
	
	@Transactional
	public User getUserByUsername(String username) {
		return ur.findUserByUsername(username);
	}
	
	@Transactional
	public int createUser(User u) {
		u.setRole(UserRole.BASIC_USER);
		u.setRegisterDateTime(LocalDateTime.now());
		ur.save(u);
		return u.getId();
	}
}
