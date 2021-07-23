package com.revature;

public class Driver {

	public static void main(String[] args) {
		
		Runnable job = () -> {
			System.out.println("This is a lambda expression!");
		};
		
		
		HelloThread t1 = new HelloThread();
		Thread t2 = new Thread(new GoodbyeThread());
		Thread t3 = new Thread(job);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		System.out.println("The state of t1 is: " + t1.getState());
		
		try {
			// Waits for t1 to execute before completing execution of main method
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End of the main method!");
	}

}

class HelloThread extends Thread{
	@Override
	public void run() {
		//Thread behavior here
		System.out.println("Hello Thread has started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello!");
	}
}

class GoodbyeThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Goodbye Thread has started");
	}
}
