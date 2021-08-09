package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.AuthServiceImpl;
import com.revature.util.CorsFix;

public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AuthService as = new AuthServiceImpl();

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		CorsFix.addCorsHeader(rq.getRequestURI(), rs);
		
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");

		try {
			User user = as.login(username, password);
			if (user != null) {
//				HttpSession session = rq.getSession();
//				session.setAttribute("user", username);

				String token = user.getId() + ":" + user.getRole();
				rs.setHeader("Authorization", token);
				rs.setStatus(200);
			} else {

			}
		} catch (UserNotFoundException e) {
			rs.sendError(404);
		}
	}
	
}
