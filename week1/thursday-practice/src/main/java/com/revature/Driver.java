package com.revature;

import com.revature.controllers.MenuScreen;
import com.revature.daos.UserDao;
import com.revature.daos.UserFile;
import com.revature.exceptions.UserNotFoundException;

public class Driver {

	public static void main(String[] args) {
		MenuScreen.display();
	}

}
