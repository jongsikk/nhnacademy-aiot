package com.nhnacademy.app;

import org.apache.commons.math3.random.RandomDataGenerator;

public class ApacheCommonsRandom {
    public static void main(String[] args) {
        RandomDataGenerator random = new RandomDataGenerator(null);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(1, 100));
        }
    }
}