package com.nhnacademy.thread;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Channel {
    private final Queue<Request> queue;
    private final int queueMaxSize;

    public Channel(int queueMaxSize) {
        queue = new LinkedList<>();
        this.queueMaxSize = queueMaxSize;
    }

    public synchronized void addRequest(Request request) {
        while (queue.size() >= queueMaxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("add queue", e);
            }
        }
        queue.add(request);
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("take queue", e);
            }
        }
        notifyAll();
        return queue.poll();
    }
}
