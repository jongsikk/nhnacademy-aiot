package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable {
    private final Channel channel;
    private final Employee employee;

    public Worker(Channel channel, Employee employee) {
        this.channel = channel;
        this.employee = employee;
    }

    @Override
    public void run() {
        while (true) {
            Request request = channel.takeRequest();
            request.execute();
            log.info("직원:{}이 쿠폰을 발급했습니다.", employee.getName());
        }
    }
}
