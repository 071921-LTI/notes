package com.revature.models;

import com.revature.interfaces.Flyable;

public class Human extends Animal implements Flyable {
	private String name;

	public Human() {
		super(); // Animal()
	}
	
	// Indicates that a method was overriden
	@Override
	public double move() {
		System.out.println("I'm a human, I drive a car.");
		return 100;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fly() {
		System.out.println("I'm flyin'");
		
	}
	
}
