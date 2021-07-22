package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.AuthException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.AuthServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class MenuScreen {
	
	static Scanner sc = new Scanner(System.in);
	static UserService us = new UserServiceImpl();
	static AuthService as = new AuthServiceImpl();
	
	// Menu logic
	public static void display() {
		String input; 
		do {
		System.out.println("Enter: \n1 to login\n2 to register\n3 to exit");
		input = sc.nextLine();
		switch(input) {
		case "1":
			System.out.println("Enter username:");
			String username = sc.nextLine();

			try {
				User user = us.getUser(username);
				System.out.println("Enter password:");
				String password = sc.nextLine();
				User toBeChecked = new User(username, password);
//				if(as.login(toBeChecked)) {
//					// do something
//				}
				if(as.login(toBeChecked)) {
				System.out.println("Successfully logged in!");
				input = "3";
				} else {
					System.out.println("Wrong credentials");
				}
			} catch (UserNotFoundException e) {
				System.out.println("User was not found.");
			} catch (AuthException e) {
				System.out.println("Wrong credentials");
			}
			break;
		case "2":
			break;
			default:
		}
		} while(!input.equals("3"));
	}
}
