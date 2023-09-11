package com.nhnacademy.quiz;

public class ThreadCounter extends Thread {
    int count = 0;
    int maxCount;

    public ThreadCounter(String name, int maxCount) {
        super(name);
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        try {
            while (maxCount > count) {
                count++;
                System.out.println(getName() + " : " + count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        ThreadCounter counter = new ThreadCounter("counter", 5);
        ThreadCounter counter2 = new ThreadCounter("counter2", 5);

        counter.start();
        counter2.start();

        System.out.println("Finished");
    }

}