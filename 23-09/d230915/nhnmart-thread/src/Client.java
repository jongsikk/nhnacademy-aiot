package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client extends Thread {
    private final Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Customer customer = CustomerGenerator.getCustomerGenerator().next();
            Request request = new CouponRequest(customer);
            channel.addRequest(request);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error("", e);
            }
        }
    }
}
