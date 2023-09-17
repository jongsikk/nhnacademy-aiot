package com.nhnacademy.thread;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(20);
        WorkerPool workerPool = new WorkerPool(3, channel);

        workerPool.start();

        new Thread(new Client(channel)).start();
        new Thread(new Client(channel)).start();
        new Thread(new Client(channel)).start();
    }
}
