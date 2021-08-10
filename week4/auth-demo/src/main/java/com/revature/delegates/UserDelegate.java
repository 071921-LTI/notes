package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDelegate implements Delegatable {

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
		 * TODO: 
		 * 		- if a path param is provided( /users/{id}) return user by an id
		 * 			- return 404 status code if not found
		 * 		- if no path param is provided( /users ) return all users
		 */

	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePut");

	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handlePost");
		
		/*
		 * TODO: 
		 *		- create a user based on JSON data provided in the body
		 *			- return 400 if unable to
		 *			- return 201 if successful
		 */

	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handleDelete");

	}

}
