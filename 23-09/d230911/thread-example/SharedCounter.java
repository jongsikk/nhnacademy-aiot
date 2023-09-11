package com.nhnacademy.quiz;

public class SharedCounter extends Thread {
    SharedCount sharedCount;
    int count;
    int maxCount;
    Thread thread;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        thread = new Thread(name);
        this.sharedCount = sharedCount;
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && count < maxCount) {
            count++;
            synchronized (sharedCount) {
                sharedCount.increment();
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();
        while (counter1.isAlive() || counter2.isAlive())
            ;

        System.out.println("counter1 count : " + counter1.getCount());
        System.out.println("counter2 count : " + counter2.getCount());
        System.out.println("shared count : " + sharedCount.getCount());
    }
}
