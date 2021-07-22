package com.revature.interfaces;

public interface Flyable extends Cloneable{

//	public static final int speed = 100; implicitely public static final
	int speed = 100;
//	public abstract void fly();
	public void fly(); // implicitely abstract
	
	// allows to provide an implementation to a method in an interface
	public default void swim() {
		System.out.println("We swimmin'");
	}
	
	// Gives an error because an abstract method cannot have an implementation
//	public void run() {
//		System.out.println("Runnin'");
//	}
}
