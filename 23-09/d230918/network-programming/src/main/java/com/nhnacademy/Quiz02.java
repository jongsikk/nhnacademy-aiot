package com.nhnacademy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Quiz02 {
    public static void main(String[] args) {
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            try (Socket socket = new Socket("localhost", i);) {
                System.out.println("Port " + i + " 열려 었습니다.");
            } catch (Exception e) {
            }
        }
    }
}
