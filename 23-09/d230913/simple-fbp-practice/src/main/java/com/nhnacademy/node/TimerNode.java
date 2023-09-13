package com.nhnacademy.node;

public class TimerNode extends InputNode {

    public TimerNode(int interval) {
        super(1);
        setInterval(interval);
    }

    public synchronized void process() {

    }
}
