package com.revature.daos;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserPostgres implements UserDao {

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int addUser(User user) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteUser(int id) throws UserNotFoundException {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
