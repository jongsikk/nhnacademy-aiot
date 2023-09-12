package main.java.com.nhnacademy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    private Semaphore box;
    private Semaphore things;
    private ExecutorService executor;

    public Store() {
        box = new Semaphore(10);
        things = new Semaphore(0);
        executor = Executors.newFixedThreadPool(5);
    }

    public void enter(Consumer consumer) {
        if (!isAcquire()) {
            executor.submit(consumer);
        }
    }

    public void exit() throws InterruptedException {

        throw new InterruptedException();
        // executor.shutdown();
    }

    public boolean isAcquire() {
        return things.tryAcquire();
    }

    public synchronized void buy() throws InterruptedException {
        while (!things.tryAcquire()) {
            wait();
        }
        long waitingTime = 1000 + ThreadLocalRandom.current().nextInt(9000);
        Thread.sleep(waitingTime);
        box.release();
        System.out.println("소비자 물건 구매, 남은 상품" + (10 - box.availablePermits()));
        notifyAll();
    }

    public synchronized void sell() throws Exception {
        while (!box.tryAcquire()) {
            wait();
            throw new Exception("박스 자리 없음");
        }
        things.release();
        System.out.println("판매자 물건 납품, 남은 상품" + (10 - box.availablePermits()));
        notifyAll();
    }
}
