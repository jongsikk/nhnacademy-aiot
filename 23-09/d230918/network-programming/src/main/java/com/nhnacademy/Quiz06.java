package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Quiz06 {
    public static void main(String[] args) {
        byte[] buffer = new byte[2048];

        try (Socket socket = new Socket("ems.nhnacademy.com", 12345);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())) {
            System.out.println("서버에 연결되었습니다.");
            String line;
            while ((line = reader.readLine()) != null) {
                bufferedOutputStream.write(line.getBytes());
                bufferedOutputStream.flush();
                if (line.equals("exit")) {
                    break;
                }
                int length = bufferedInputStream.read(buffer);
                // System.out.println("Read : " + line);
                System.out.println(new String(buffer, 0, length));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
