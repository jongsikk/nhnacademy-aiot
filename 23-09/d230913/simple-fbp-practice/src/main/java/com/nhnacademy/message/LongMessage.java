package com.nhnacademy.message;

public class LongMessage extends Message {
    long message;

    public LongMessage(long message) {
        this.message = message;
    }

    public long getPayload() {
        return message;
    }
}
