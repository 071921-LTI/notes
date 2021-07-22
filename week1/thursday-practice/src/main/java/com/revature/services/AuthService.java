package com.revature.services;

import com.revature.exceptions.AuthException;
import com.revature.models.User;

public interface AuthService {

	public abstract boolean login(User user) throws AuthException;
}
