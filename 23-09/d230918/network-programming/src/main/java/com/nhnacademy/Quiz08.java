package com.nhnacademy;

import java.net.ServerSocket;
import java.net.Socket;

public class Quiz08 {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

            System.out.println(socket.getInetAddress().getHostAddress() + " : " + socket.getPort());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
