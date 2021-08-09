package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PokemonDelegate implements Delegatable{

	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		/*
		 *  TODO:
		 *  	- Map request to appropriate handleX request
		 */
		
		
	}

	@Override
	public void handleGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		/*
		 * TODO: 
		 * 		- if a path param is provided( /users/{id}) return user by an id
		 * 			- return 404 status code if not found
		 * 		- if no path param is provided( /users ) return all users
		 */
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
	
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		/*
		 * TODO: 
		 *		- create a pokemon based on JSON data provided in the body
		 *			- assign a user based on the token in the request
		 *			- return 400 if unable to
		 *			- return 201 if successful
		 */
		
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
