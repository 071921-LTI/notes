package com.revature;

import java.util.Scanner;

import com.revature.exceptions.BrokenMotorException;
import com.revature.models.Car;

public class Application {

	public static void main(String... args) {

		
		// Unchecked exception, not checked by the compiler
		int x = 0/0;
		m1();
		
		try {
			m2();
		} catch (Exception e) {
			System.out.println("m2 has been handled");
			// How to skip finally block
//			System.exit(0);
		} finally {
			System.out.println("This is a finally block!");
		}
		
		// try-with-resources, automatically closes the resource
		try(Scanner sc = new Scanner(System.in)){
			//risky code
		}
		catch(Exception e){
			//handling exception
		}
		
		System.out.println("This is the end.");
		
		Car c = new Car();
		try {
			c.makeNoise(-1, 1, "vroom", "hello");
		} catch (BrokenMotorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void m1() throws RuntimeException{
//		throw new RuntimeException();
		throw new RuntimeException("Runtime exception, by Kevin");
	}
	
	public static void m2() throws Exception{
		throw new Exception("Checked Exception, by Kevin");
	}
}
