package com.revature.whackystuff;

public class Counter {

	int count;
	
	public synchronized void increment() {
		count++;
	}
	
}
