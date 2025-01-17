package com.agulan.java.concurrency.runnable;

public class SimpleRunnable {

	public static void main(String[] args) {
		Runnable runnable = () -> System.out.printf("Running in thread [%s]", Thread.currentThread().getName());

		Thread thread = new Thread(runnable);
		thread.setName("my-runnable-thread");

		thread.start();

	}
}
