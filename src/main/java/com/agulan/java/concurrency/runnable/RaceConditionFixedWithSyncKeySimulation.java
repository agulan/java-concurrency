package com.agulan.java.concurrency.runnable;

import com.agulan.java.concurrency.runnable.model.LongWrapperWithSyncKey;

import java.util.stream.IntStream;

public class RaceConditionFixedWithSyncKeySimulation {

    public static void main(String[] args) {

        LongWrapperWithSyncKey key = new LongWrapperWithSyncKey(0L);
        int n = 1000;

        Runnable r = () -> IntStream.range(0, n).forEach(i -> key.incrementValue());

        Thread[] threads = new Thread[n];

        // start n threads
        IntStream.range(0, threads.length).forEach(i -> {
            threads[i] = new Thread(r);
            threads[i].start();
        });

        // force the thread to finish
        IntStream.range(0, threads.length).forEach(i -> {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Value = " + key.getValue());

    }
}
