package main.java.com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Store store;
    Thread thread;

    public Producer(Store store) {
        thread = new Thread(this, "Producer");
        this.store = store;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            long waitingTime = 1000 + ThreadLocalRandom.current().nextInt(1000);
            try {
                Thread.sleep(waitingTime);
                store.sell();
            } catch (Exception e) {
                // Thread.currentThread().interrupt();
                System.out.println("납품 대기");
            }
        }
    }

    public static void main(String[] args) {
        Producer p = new Producer(new Store());
        p.start();
    }
}