package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.UserDao;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserDao ud;

	@InjectMocks
	UserService us;

	User user = new User(1, "username", "password", "manager");

	@Test
	public void addUserNotExist() {
		Mockito.when(ud.addUser(user)).thenReturn(1);
		assertEquals(us.addUser(user), true);
	}

	@Test
	public void addUserExists() {
		Mockito.when(ud.addUser(user)).thenReturn(null);
		assertEquals(us.addUser(user), false);
	}

	@Test
	public void getUsersExists() {
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user);

		Mockito.when(ud.getUsers()).thenReturn(users);

		assertEquals(users.size(), us.getUsers().size());
	}

	@Test
	public void getUsersNotExists() {
		List<User> users = new ArrayList<>();

		Mockito.when(ud.getUsers()).thenReturn(users);

		assertEquals(users.size(), us.getUsers().size());
	}

	@Test
	public void getUserByIdExists() throws UserNotFoundException {
		Mockito.when(ud.getUserById(1)).thenReturn(user);
		
		assertEquals(user, us.getUserById(1));
	}
	
	@Test
	public void getUserByIdNotExists() throws UserNotFoundException {
		Mockito.when(ud.getUserById(1)).thenThrow(new UserNotFoundException());
		
		assertThrows(UserNotFoundException.class, () -> us.getUserById(1));
	}
	
	@Test
	public void getUserByUsernameExists() throws UserNotFoundException {
		Mockito.when(ud.getUserByUsername("username")).thenReturn(user);
		
		assertEquals(user, us.getUserByUsername("username"));
	}
	
	@Test
	public void getUserByUsernameNotExists() throws UserNotFoundException {
		Mockito.when(ud.getUserByUsername("username")).thenThrow(new UserNotFoundException());
		
		assertThrows(UserNotFoundException.class, () -> us.getUserByUsername("username"));
	}
	
	public void deleteUserExists() throws UserNotFoundException {
		Mockito.when(ud.deleteUser(1)).thenReturn(1);
		
		assertEquals(us.deleteUser(1), true);
	}
	
	public void deleteUserNotExists() throws UserNotFoundException {
		Mockito.when(ud.deleteUser(1)).thenThrow(new UserNotFoundException());
		
		assertEquals(us.deleteUser(1), false);
	}

}
