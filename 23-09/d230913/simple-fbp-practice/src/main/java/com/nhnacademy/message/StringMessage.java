package com.nhnacademy.message;

public class StringMessage extends Message {
    String message;

    public StringMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
