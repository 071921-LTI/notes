package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="no user found")
	@ExceptionHandler(Exception.class)
	public void handleException() {
		// log or something
		System.out.println("E was thrown!");
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="no user found")
	@ExceptionHandler(UserNotFoundException.class)
	public void handleUserNotFoundException() {
		// log or something
		System.out.println("UNFE was thrown!");
	}
}
