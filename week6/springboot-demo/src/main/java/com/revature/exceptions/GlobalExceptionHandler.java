package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="User already exists.")
	@ExceptionHandler(UserAlreadyExistsException.class)
	public void handleUserAlreadyExistsException() {
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="User does not exists.")
	@ExceptionHandler(UserDoesNotExistException.class)
	public void handleUserDoesNotExistException() {
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid Username")
	@ExceptionHandler(InvalidUsernameException.class)
	public void handleInvalidUsernameException() {
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No user.")
	@ExceptionHandler(AuthenticationException.class)
	public void handleAuthenticationException() {
	}
	
	@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="User does not have permissions.")
	@ExceptionHandler(AuthorizationException.class)
	public void handleAuthorizationException() {
	}
}
