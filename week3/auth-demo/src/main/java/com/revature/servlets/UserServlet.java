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

		String pathInfo = rq.getPathInfo();

		if (pathInfo != null) {
			int id = Integer.parseInt(pathInfo.substring(1));
			try (PrintWriter pw = rs.getWriter()) {
				User user = us.getUserById(id);
				pw.write(new ObjectMapper().writeValueAsString(user));
			} catch (UserNotFoundException e) {
				rs.sendError(404);
			}
		} else {
			String authToken = rq.getHeader("Authorization");
			try {
				if(authToken == null || as.authorize(authToken)) {
					rs.sendError(403);
				}else {
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
