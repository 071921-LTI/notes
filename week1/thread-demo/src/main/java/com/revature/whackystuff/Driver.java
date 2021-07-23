package com.revature.whackystuff;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter count = new Counter();
		CounterRunnable countJob = new CounterRunnable(count);
		Thread t1 = new Thread(countJob);
		Thread t2 = new Thread(countJob);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final Count: " + count.count);
	}

}
