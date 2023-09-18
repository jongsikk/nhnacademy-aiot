package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;

public class Ex03 {
    public static void main(String[] args) {
        byte[] buffer = new byte[2048];
        try (Socket socket = new Socket("localhost", 12345);
                InputStream inputStream = socket.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            System.out.println("서버에 연결되었습니다.");
            int length;
            while ((length = bufferedInputStream.read(buffer)) >= 0) {
                String line = new String(buffer, 0, length).trim();
                if (line.equals("exit")) {
                    break;
                }
                System.out.println("Read : " + line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
