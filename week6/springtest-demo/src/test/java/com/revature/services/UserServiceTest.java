package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.data.UserRepository;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

@SpringBootTest(classes=UserServiceImpl.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository mockUserRepository;
	
	static List<User> mockUsers; 
	
	static User mockUser;
	
	@BeforeAll
	public static void setUp(){
		User u1 = new User(1, "Tommy");
		User u2 = new User(2, "James");
		
		mockUsers = new ArrayList<>();
		mockUsers.add(u1);
		mockUsers.add(u2);
		
		mockUser = u1;
	}
	
	@Test
	public void getByIdValid() {
		when(mockUserRepository.getById(1)).thenReturn(mockUser);
		
		assertEquals(mockUser, userService.getUserById(1));
	}
	
	@Test
	public void getByIdInvalid() {
		when(mockUserRepository.getById(5)).thenThrow(EntityNotFoundException .class);
		
		assertThrows(UserNotFoundException.class, () -> userService.getUserById(5));
	}
}
