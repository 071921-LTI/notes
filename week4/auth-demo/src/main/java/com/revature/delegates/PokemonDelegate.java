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
import com.revature.models.Pokemon;
import com.revature.models.User;
import com.revature.services.PokemonService;
import com.revature.services.PokemonServiceImpl;

public class PokemonDelegate implements Delegatable{
	PokemonService ps = new PokemonServiceImpl();
	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		/*
		 *  TODO:
		 *  	- Map request to appropriate handleX request
		 */
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
		/*
		 * TODO: 
		 * 		- if a path param is provided( /users/{id}) return user by an id
		 * 			- return 404 status code if not found
		 * 		- if no path param is provided( /users ) return all users
		 */
		String pathNext = (String) rq.getAttribute("pathNext");
		String authToken = rq.getHeader("Authorization");
		System.out.println(authToken);
//		try {
//			if(authToken == null || !as.authorize(authToken)) {
//				rs.sendError(403);
//			}else {
		if (pathNext != null) {
			try {
				Pokemon p = ps.getPokemonById(Integer.valueOf(pathNext));
				try (PrintWriter pw = rs.getWriter()) {
					pw.write(new ObjectMapper().writeValueAsString(p));
				}
			} 
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		else {
			List<Pokemon> p = ps.getPokemon();
			try (PrintWriter pw = rs.getWriter()) {
				pw.write(new ObjectMapper().writeValueAsString(p));
			}
		}
		
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
		
		InputStream request = rq.getInputStream();
		// Converts the request body into a User.class object
		Pokemon p = new ObjectMapper().readValue(request, Pokemon.class);
		
		if (!ps.addPokemon(p)) {
			rs.sendError(400, "Unable to add user.");
		} else {
			rs.setStatus(201);
		}
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
