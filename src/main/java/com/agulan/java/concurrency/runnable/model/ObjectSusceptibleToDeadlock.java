package com.agulan.java.concurrency.runnable.model;

public class ObjectSusceptibleToDeadlock {
	
	private final Object key1 = new Object();
	private final Object key2 = new Object();

	public void functionA() {


		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in functionA()");
			functionB();
		}
	}

	public void functionB() {
		synchronized (key2) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in functionB()");
			functionC();
		}
	}

	public void functionC() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in functionC()");
		}
	}
}
