package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestHelper rh = new RequestHelper();
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
		addCorsHeader(rq.getRequestURI(),rs);
		rh.process(rq, rs);
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
		doGet(rq,rs);
	}
	
	protected void doPut(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
		doGet(rq,rs);
	}
	
	protected void doDelete(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
		doGet(rq,rs);
	}
	
	public static void addCorsHeader(String requestURI, HttpServletResponse rs) {
		rs.addHeader("Access-Control-Allow-Origin", "*");
		rs.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		rs.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization");
		rs.addHeader("Access-Control-Expose-Headers", "Content-Type, Accept, Authorization");
	}
}
