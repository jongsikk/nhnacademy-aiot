package com.nhnacademy.quiz;

public class Counter {
    String name;
    int count;

    public Counter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void run() {
        try {
            int i = 1;
            while (i <= count) {
                System.out.println(name + " : " + i++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Counter c1 = new Counter("jongsik2", 10);
        Counter c2 = new Counter("new", 10);
        c1.run();
        c2.run();

        System.out.println("finished");
    }
}
