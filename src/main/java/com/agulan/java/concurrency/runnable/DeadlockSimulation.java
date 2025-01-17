package com.agulan.java.concurrency.runnable;


import com.agulan.java.concurrency.runnable.model.ObjectSusceptibleToDeadlock;

public class DeadlockSimulation {

	public static void main(String[] args) throws InterruptedException {

		ObjectSusceptibleToDeadlock objectSusceptibleToDeadlock = new ObjectSusceptibleToDeadlock();
		
		Runnable r1 = objectSusceptibleToDeadlock::functionA;
		Runnable r2 = objectSusceptibleToDeadlock::functionB;
		
		Thread t1 = new Thread(r1);
		t1.start();

		Thread t2 = new Thread(r2);
		t2.start();

		t1.join();
		t2.join();
	}
}
