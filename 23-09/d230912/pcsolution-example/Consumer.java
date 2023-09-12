package main.java.com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    Store store;
    Thread thread;

    public Consumer(String name, Store store) {
        thread = new Thread(this, name);
        this.store = store;
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            long waitingTime = 1000 + ThreadLocalRandom.current().nextInt(9000);
            System.out.println(getThread().getName() + " 입장");
            Thread.sleep(waitingTime);
            store.buy();
            store.exit();
        } catch (InterruptedException e) {
            System.out.println(getThread().getName() + " 퇴장");
            Thread.currentThread().interrupt();
        }
    }
}
