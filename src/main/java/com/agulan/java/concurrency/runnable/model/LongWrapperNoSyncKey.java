package com.agulan.java.concurrency.runnable.model;

public class LongWrapperNoSyncKey {

    private long l;

    public LongWrapperNoSyncKey(long l) {
        this.l = l;
    }

    public long getValue() {
		return l;
	}

    public void incrementValue() {
        l = l + 1;
    }
}
