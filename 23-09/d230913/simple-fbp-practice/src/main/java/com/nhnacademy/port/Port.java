package com.nhnacademy.port;

import java.util.LinkedList;
import java.util.Queue;

import com.nhnacademy.message.LongMessage;
import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;

public class Port {
    Queue<Message> messageQueue;

    public Port() {
        messageQueue = new LinkedList<>();
    }

    public void put(Message message) {
        messageQueue.add(message);
    }

    public boolean hasMessage() {
        return !messageQueue.isEmpty();
    }

    public Message get() {
        return messageQueue.poll();
    }

    public boolean isStringMessage() {
        return messageQueue.peek() instanceof StringMessage;
    }

    public boolean isLongMessage() {
        return messageQueue.peek() instanceof LongMessage;
    }
}
