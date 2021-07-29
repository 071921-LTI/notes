package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.EvenNumberException;

public class Driver {

	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		System.out.println("This is a SysOut");
		log.trace("This is trace");
		log.debug("This is a debug");
		log.info("This is an info");
		log.warn("This is a warning");
		log.error("This an error");
		log.fatal("App dead");
		
		try {
			add(1,1);
		} catch (EvenNumberException e) {
			log.error("Exception was thrown: " + e.fillInStackTrace());
			e.printStackTrace();
		}
	}
	
	public static int add(int a, int b) throws EvenNumberException {
		int sum = a + b;
		if(sum % 2 == 0) {
			throw new EvenNumberException();
		}
		return sum;
	}

}
