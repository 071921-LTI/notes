package com.revature;

// imports packages/classes from a different location
import java.util.Scanner;
// import java.util.*; - imports all classes within that package, better practice to only import what is needed


public class App {
	
	static Scanner sc;
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		sc = new Scanner(System.in);
		
		System.out.println("Hello, please enter a sentence:");
		String input = sc.nextLine();
		
		System.out.println("You have entered " + input);
		
		String[] words = input.split(" ");
		for(String i : words) {
			System.out.println(i);
		}
		
		System.out.println("Please enter a number: ");
		int intInput = sc.nextInt();
		
		System.out.println("You have entered " + intInput);
		sc.nextLine(); // This sc.nextLine() flushes/grabs the leftovers
		
		
		App.askName();
		
		sc.close();
		
		/*
		 *  TODO: Create a menu that gives a user multiple options
		 *  	- Option 1: get a random number
		 *  	- Option 2: Reverse a word of the user's choice
		 *  	- Option 3: exit the program
		 *  This menu should repeat until the use decides to exit
		 */
	}
	
	public static void askName() {
		System.out.println("Please enter your name:");
		String name = sc.nextLine();
		System.out.println("Your name is: " + name);
	}
}
