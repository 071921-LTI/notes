package com.revature.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UserAlreadyExistsException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;

@WebMvcTest(UserControllerImpl.class)
public class UserControllerTest {

	@MockBean
	private UserService mockUserService;
	
	@Autowired
	private MockMvc mockMvc;
	
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
	public void getAllUsers() throws Exception {
		when(mockUserService.getUsers()).thenReturn(mockUsers);
		
		mockMvc.perform(get("/users")
				.contentType(MediaType.APPLICATION_JSON))
		
				.andExpect(status().isOk())
				
				.andExpect(jsonPath("$[0].name").value("Tommy"))
				.andExpect(jsonPath("$[1].name", is("James")));
	}
	
	@Test
	public void getUserByIdValid() throws Exception {
		when(mockUserService.getUserById(1)).thenReturn(mockUser);
		
		mockMvc.perform(get("/users/1")
				.contentType(MediaType.APPLICATION_JSON))
		
				.andExpect(status().isOk())
				
				.andExpect(jsonPath("$.name").value("Tommy"));
	}
	
	@Test
	public void getUserByIdInvalid() throws Exception {
		when(mockUserService.getUserById(5)).thenThrow(UserNotFoundException.class);
		
		mockMvc.perform(get("/users/5"))
		
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void createUserValid() throws Exception {
		when(mockUserService.createUser(new User("testUser"))).thenReturn(new User(3, "testUser"));
		
		mockMvc.perform(post("/users")
				.content(convertToJson(new User("testUser")))
				.contentType(MediaType.APPLICATION_JSON))
		
				.andExpect(status().isCreated())
				
				.andExpect(jsonPath("$.id").value("3"));
	}
	
	@Test
	public void createUserInvalid() throws Exception {
		when(mockUserService.createUser(new User("Tommy"))).thenThrow(UserAlreadyExistsException.class);
		
		mockMvc.perform(post("/users")
				.content(convertToJson(new User("Tommy")))
				.contentType(MediaType.APPLICATION_JSON))
		
				.andExpect(status().isBadRequest());
	}
	
	public static String convertToJson(User user) {
		try {
			return new ObjectMapper().writeValueAsString(user);
		} catch (JsonProcessingException e) {
			throw new RuntimeException();
		}
	}
}
