package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.AuthServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;
import com.revature.util.CorsFix;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us = new UserServiceImpl();
	AuthService as = new AuthServiceImpl();

	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

		CorsFix.addCorsHeader(rq.getRequestURI(), rs);
		System.out.println("In doGetMethod");

		// users/3
		
		/*
		 * doGet needs to be able to handle either
		 *		- returning all users: /users
		 *		- returning a specific user by its id: /users/{id}
		 */

		String pathInfo = rq.getPathInfo();

		/*
		 * meaning it's not just /users
		 */
		if (pathInfo != null) {
			// convert the id received to an int
			int id = Integer.parseInt(pathInfo.substring(1));
			
			try (PrintWriter pw = rs.getWriter()) {
				// retrieve the user with the passed-in id
				User user = us.getUserById(id);
				// "write the user to the response body"
				rs.setStatus(200);
				pw.write(new ObjectMapper().writeValueAsString(user));
			} catch (UserNotFoundException e) {
				// if no user with that id is found, return a 404
				rs.sendError(404);
			}
		} else {
			// "protecting" an endpoint with authorization logic, making sure that a user is authenticated before proceeding further.
			String authToken = rq.getHeader("Authorization");
			try {
				if(authToken == null || !as.authorize(authToken)) {
					rs.sendError(403);
				}else {
					/*
					 * for /users endpoint, returning all users
					 */
					List<User> users = us.getUsers();
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(users));
					}
				}
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void doPut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		/*
		 * for /users/{id} update a specific user
		 */
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//		String username = rq.getParameter("username");
//		String password = rq.getParameter("password");
//		String role = rq.getParameter("role");
//		if (!us.addUser(new User(username, password, role))) {
//			rs.sendError(400, "Unable to add user.");
//		} else {
//			rs.setStatus(201);
//		}
		CorsFix.addCorsHeader(rq.getRequestURI(), rs);
		
		InputStream request = rq.getInputStream();
		// Converts the request body into a User.class object
		User user = new ObjectMapper().readValue(request, User.class);
		
		if (!us.addUser(user)) {
			rs.sendError(400, "Unable to add user.");
		} else {
			rs.setStatus(201);
		}
	}
}
