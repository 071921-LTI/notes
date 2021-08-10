package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.AuthServiceImpl;
import com.revature.util.CorsFix;

public class AuthDelegate implements Delegatable{
	AuthService as = new AuthServiceImpl();
	private static final long serialVersionUID = 1L;
	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

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
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		
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

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
