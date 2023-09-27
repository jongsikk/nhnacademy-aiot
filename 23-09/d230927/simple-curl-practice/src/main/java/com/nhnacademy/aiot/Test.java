package com.nhnacademy.aiot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String host = "httpbin.org";
        int port = 80;
        String data = "{\"hello\": \"world\"}";
        try (Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));) {
            out.write("POST /post HTTP/1.1\r\n");
            out.write(("Host: " + host + "\r\n"));
            out.write("Content-Type: application/json\r\n");
            out.write("Content-Length: " + data.length() + "\r\n");
            out.write("\r\n");
            out.write(data);
            out.flush();
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
