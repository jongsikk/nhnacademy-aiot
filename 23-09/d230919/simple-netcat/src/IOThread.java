package com.nhnacademy.aiot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class IOThread implements Runnable {
    BufferedReader reader;
    BufferedWriter writer;

    public IOThread(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
