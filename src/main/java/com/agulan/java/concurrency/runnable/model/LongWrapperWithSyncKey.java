package com.agulan.java.concurrency.runnable.model;

public class LongWrapperWithSyncKey {

    private final Object key = new Object();
    private long l;

    public LongWrapperWithSyncKey(long l) {
        this.l = l;
    }

    public long getValue() {
        synchronized (key) {
            return l;
        }
    }

    public void incrementValue() {
        synchronized (key) {
            l = l + 1;
        }
    }

}
