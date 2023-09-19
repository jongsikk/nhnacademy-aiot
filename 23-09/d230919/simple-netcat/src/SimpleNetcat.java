package com.nhnacademy.aiot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SimpleNetcat {

    public static void main(String[] args) {
        boolean server = args[0].equals("-l");
        String hostname = server ? null : args[0];
        int port = Integer.parseInt(args[1]);

        try (ServerSocket serverSocket = server ? new ServerSocket(port) : null;
                Socket socket = server ? serverSocket.accept() : new Socket(hostname, port);
                BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter socketWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter terminalWriter = new BufferedWriter(new OutputStreamWriter(System.out));) {

            Thread receiver = new Thread(new IOThread(socketReader, terminalWriter));
            Thread sender = new Thread(new IOThread(terminalReader, socketWriter));
            receiver.start();
            sender.start();

            receiver.join();
            System.exit(0);
        } catch (InterruptedException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
