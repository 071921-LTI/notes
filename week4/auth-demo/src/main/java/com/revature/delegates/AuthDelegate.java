package com.revature.delegates;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.AuthServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class AuthDelegate implements Delegatable {

    AuthService as = new AuthServiceImpl();
    UserService us = new UserServiceImpl();

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
        InputStream credentials = rq.getInputStream();

        User user = new ObjectMapper().readValue(credentials, User.class);
        try {
            User loggedInUser = as.login(user.getUsername(), user.getPassword());

            if (loggedInUser != null) {
                System.out.println(loggedInUser.getId());
                String token = "" + loggedInUser.getId();
                System.out.println(loggedInUser.getId());
                rs.setHeader("Authorization", token);
                rs.setStatus(200);
            } else {
                rs.sendError(404);
            }
        } catch (UserNotFoundException e) {
            rs.sendError(404);
        }

        
        
    }

    @Override
    public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        InputStream credentials = rq.getInputStream();

        User newUser = new ObjectMapper().readValue(credentials, User.class);

        boolean created = us.addUser(newUser);

        if (created) {
            rs.setStatus(201);
        } else {
            rs.sendError(403);
        }
        
    }

    @Override
    public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
    }
    
}
