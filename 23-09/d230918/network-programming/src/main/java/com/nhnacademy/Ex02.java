package com.nhnacademy;

import java.io.IOException;
import java.net.Socket;

public class Ex02 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("ems.nhnacademy.com", 12345);
            System.out.println("서버에 연결되었습니다.");

            socket.getOutputStream().write("Hello".getBytes());
            socket.getOutputStream().flush();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
