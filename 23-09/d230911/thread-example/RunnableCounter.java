package com.nhnacademy.quiz;

public class RunnableCounter implements Runnable {
    String name;
    int count = 1;
    int maxCount;
    // boolean isRunning;
    Thread thread;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        thread = new Thread();
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        // isRunning = true;
        thread = Thread.currentThread();

        try {
            while (!Thread.currentThread().isInterrupted() && count <= maxCount) {
                System.out.println(name + " : " + count++);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(name + " finished");
    }

    public boolean isRunning() {
        return thread.isAlive();
    }

    public void stop() {
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableCounter rc1 = new RunnableCounter("runnableCounter1", 10);
        RunnableCounter rc2 = new RunnableCounter("runnableCounter2", 10);

        Thread t1 = new Thread(rc1);
        Thread t2 = new Thread(rc2);

        t1.start();
        t2.start();

        Thread.sleep(2000);
        rc1.stop();
        System.out.println("finished");
    }

}