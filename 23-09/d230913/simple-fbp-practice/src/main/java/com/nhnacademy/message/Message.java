package com.nhnacademy.message;

public class Message {
    static int count = 0;
    final String id;
    final long creationTime;

    public Message() {
        id = getClass().getSimpleName() + count++;
        creationTime = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public static int getCount() {
        return count;
    }

}
