package com.nhnacademy;

import java.net.Socket;

public class Quiz03 {
    public static void main(String[] args) {
        try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]));) {
            System.out.println("서버에 연결되었습니다.");
            System.out.println("Local address : " + socket.getLocalAddress());
            System.out.println("Local port : " + socket.getLocalPort());
            System.out.println("Remote address : " + socket.getRemoteSocketAddress());
            System.out.println("Remote address : " + socket.getPort());

        } catch (Exception e) {
        }
    }
}
