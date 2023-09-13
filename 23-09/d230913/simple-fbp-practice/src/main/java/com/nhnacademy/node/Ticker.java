package com.nhnacademy.node;

import com.nhnacademy.message.LongMessage;

public class Ticker extends InputNode {
    boolean counterMode = false;
    long count = 0;

    public Ticker(int count, boolean counterMode) {
        super(count);
        this.counterMode = counterMode;
    }

    public Ticker() {
        super(1);
    }

    void process() {
        if (counterMode) {
            output(new LongMessage(++count));
        } else {
            output(new LongMessage(System.currentTimeMillis()));
        }
    }
}
