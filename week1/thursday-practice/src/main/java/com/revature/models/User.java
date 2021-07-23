package com.revature.models;

import java.io.Serializable;

/*
 *  POJO: Plain Old Java Object
 *  	- any Java Object, not bound to any specific restriction
 *  	- used to define an entity
 *  Java Bean:
 *  	- Special type of POJO
 *  		- All Java Beans are POJOs but not all POJOs are Java Beans
 *  	- should implement Serializable interface
 *  		- Marker interface to provide information to the compiler that the class can be serialized
 *					- serialization: process of converting an object into a stream of byte to store that object (file, db, ...)
 *		- no-args constructor
 *		- all fields need to be private
 *		- setter/getters
 *		- (override Objects methods: toString(), equals(), hashcode())
 */

public class User implements Serializable{

	private String username;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public String toFileString() {
		return username + ":" + password;
	}
}
