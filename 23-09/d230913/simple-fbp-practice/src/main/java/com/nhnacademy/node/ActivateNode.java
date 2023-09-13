package com.nhnacademy.node;

public abstract class ActivateNode extends Node implements Runnable {
    Thread therad;
    long startTime;
    long interval = 1000;
    boolean running;

    ActivateNode() {
        super();
        therad = new Thread(this, getId());
        running = false;
    }

    ActivateNode(String name) {
        this();
        setName(name);
    }

    @Override
    public String getName() {
        return getTherad().getName();
    }

    @Override
    public void setName(String name) {
        getTherad().setName(name);
    }

    public Thread getTherad() {
        return therad;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public void start() {
        therad.start();
    }

    public void stop() {
        running = false;
        therad.interrupt();
    }

    void preprocess() {

    }

    void process() {

    }

    void postprocess() {

    }

    @Override
    public void run() {
        running = true;
        preprocess();
        long startTime = System.currentTimeMillis();
        long previousTime = startTime;
        while (running) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - previousTime;
            if (elapsedTime < interval) {
                try {
                    process();
                    Thread.sleep(interval - elapsedTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            previousTime = startTime + (System.currentTimeMillis() - startTime) / interval * interval;
        }
        postprocess();
    }

}
