package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Quiz07 {

    static class Receiver implements Runnable {
        BufferedInputStream bufferedInputStream;

        public Receiver(BufferedInputStream bufferedInputStream) {
            this.bufferedInputStream = bufferedInputStream;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[2048];
            int length;
            try {
                while ((length = bufferedInputStream.read(buffer)) >= 0) {
                    length = bufferedInputStream.read(buffer);
                    System.out.println(new String(buffer, 0, length));
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    static class Sender implements Runnable {
        BufferedOutputStream bufferedOutputStream;
        BufferedReader bufferedReader;

        public Sender(BufferedOutputStream bufferedOutputStream, BufferedReader bufferedReader) {
            this.bufferedOutputStream = bufferedOutputStream;
            this.bufferedReader = bufferedReader;
        }

        @Override
        public void run() {
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedOutputStream.write(line.getBytes());
                    bufferedOutputStream.flush();
                    if (line.equals("exit")) {
                        break;
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        byte[] buffer = new byte[2048];

        try (Socket socket = new Socket("ems.nhnacademy.com", 12345);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())) {
            System.out.println("서버에 연결되었습니다.");

            Thread receiverThread = new Thread(new Receiver(bufferedInputStream));
            Thread senderThread = new Thread(new Sender(bufferedOutputStream, reader));
            receiverThread.start();
            senderThread.start();
            try {
                receiverThread.join();
                senderThread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}