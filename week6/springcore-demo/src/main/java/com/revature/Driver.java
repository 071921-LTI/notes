package com.revature;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Car;
import com.revature.models.User;

public class Driver {

	@Bean
	public Scanner getPrintWriter() {
		return new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		
		// Traditional way to create a car
		Car c = new Car();
		
		// Using Spring
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c1 = (Car) ac.getBean("car");
		c1.setModel("Should be singleton");
		System.out.println(c1);
		Car c2 = (Car) ac.getBean("car");
		System.out.println(c2);

		User u = (User) ac.getBean("user");
		System.out.println(u);
	}

}
