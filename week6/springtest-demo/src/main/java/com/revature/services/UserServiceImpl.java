package com.revature.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.UserRepository;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository ur;

	@Autowired
	public UserServiceImpl(UserRepository ur) {
		super();
		this.ur = ur;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		try {
			return ur.getById(id);
		} catch (EntityNotFoundException  e) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
