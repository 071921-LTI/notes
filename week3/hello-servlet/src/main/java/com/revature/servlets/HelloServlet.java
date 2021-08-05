package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	// Service x = new Service();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		addCorsHeader(req.getRequestURI(), res);
		PrintWriter pw = res.getWriter();
//		pw.write("Hello World from doGet!");
		pw.write("{ \"message\":\"Hello!\"}"); // Fetch is expecting json data
		
//		req.getRequestDispatcher("index.html").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		pw.write("Hello World from doPost!");
	}
	
	private void addCorsHeader(String requestURI, HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		/*
		 *  more headers might required depending on what is requested
		 *  		- ie: might need to expose the headers
		 */
	}
}
