package main.java.com.nhnacademy;

public class PCSolution01 {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        producer.start();

        for (int i = 0; i < 10000; i++) {
            store.enter(new Consumer("consumer" + i, store));
        }

    }
}
