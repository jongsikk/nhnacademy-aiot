package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz09 {
    public static void main(String[] args) {
        int port = 1234;
        int a = 0, b = 1;

        if (a == 0) {
            b = 45;
        } else {
            b = 1;
        }

        b = ((a == 0) ? 45 : 1);

        try (ServerSocket serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            System.out.println(socket.getInetAddress().getHostAddress() + " : " +
                    socket.getPort());

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
