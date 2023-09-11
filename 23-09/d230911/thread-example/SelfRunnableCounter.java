package com.nhnacademy.quiz;

public class SelfRunnableCounter extends RunnableCounter {
    Thread thread;

    public SelfRunnableCounter(String name, int maxCount) {
        super(name, maxCount);
    }

    public void stop() {

    }
}
