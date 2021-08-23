package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.revature.services.SomeKindOfService;

@Controller
public class ExampleController {

	private SomeKindOfService ss;

	@Autowired
	public ExampleController(SomeKindOfService ss) {
		super();
		this.ss = ss;
	}
	
	
	/*
	 * Method: GET /resources/{id}
	 * 		
	 * 	Responses:
	 * 		- If valid: SC: 200 + JSON of Resource of id {id}
	 * 		- If doesn't exist: SC: 404
	 * 		- If not a valid id: SC: 4XX
	 * 
	 * Method: GET /resources?someCriteria=x
	 * 
	 * Method: POST /resources
	 * 		- JSON in Request Body
	 */
}
