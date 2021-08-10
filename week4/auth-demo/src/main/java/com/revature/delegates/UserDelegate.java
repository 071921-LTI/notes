package com.revature.delegates;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class UserDelegate implements Delegatable {

	UserService us = new UserServiceImpl();

	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// Retrieve GET, POST, PUT, DELETE...
		String method = rq.getMethod();

		switch (method) {
		case "GET":
			handleGet(rq, rs);
			break;
		case "POST":
			handlePost(rq, rs);
			break;
		case "PUT":
			handlePut(rq, rs);
			break;
		case "DELETE":
			handleDelete(rq, rs);
			break;
		default:
			rs.sendError(405);
		}

	}

	@Override
	public void handleGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handleGet");
		/*
		 * TODO: - if a path param is provided( /users/{id}) return user by an id -
		 * return 404 status code if not found - if no path param is provided( /users )
		 * return all users
		 */

		// String passed through the request if any
		String pathNext = (String) rq.getAttribute("pathNext");

		if (pathNext != null) {
			try {
				User user = us.getUserById(Integer.valueOf(pathNext));
				try (PrintWriter pw = rs.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(user));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				rs.sendError(404);
			}
		} else {
			List<User> users = us.getUsers();
			try (PrintWriter pw = rs.getWriter()) {
				pw.write(new ObjectMapper().writeValueAsString(users));
			}
		}
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePut");

	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePost");

		/*
		 * TODO: - create a user based on JSON data provided in the body 
		 * 	- return 400 if	unable to 
		 * 	- return 201 if successful
		 */
		
		InputStream request = rq.getInputStream();
		// Converts the request body into a User.class object
		User user = new ObjectMapper().readValue(request, User.class);
		
		if (!us.addUser(user)) {
			rs.sendError(400, "Unable to add user.");
		} else {
			rs.setStatus(201);
		}

	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handleDelete");

	}

}
