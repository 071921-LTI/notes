package com.revature.util;

public class RegexUtil {

	// At least 4 "valid" characters and a number
	public static final String PASSWORD_REGEX =  "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$";
}
