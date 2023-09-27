package com.nhnacademy.aiot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Request {
    String host;
    int port;
    String method;
    String path;
    String version;
    boolean verbose = false;
    boolean isBody = false;
    String header;
    String data;
    boolean isLocation = false;
    boolean isOK = false;

    public Request(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        try (Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());) {
            int count = 0;
            do {
                StringBuilder builder = new StringBuilder();
                builder.append(String.format("%s %s %s\n", method, path, version));
                builder.append(String.format("Host: %s\n", host));

                if (header != null) {
                    builder.append(header + "\n");
                }
                if (method != null && method.equalsIgnoreCase("post")) {
                    builder.append("Content-Length: " + data.length() + "\r\n");
                    builder.append("\r\n");
                    builder.append(data);
                }
                builder.append(String.format("\n", host));

                String request = builder.toString();
                out.write(request.getBytes());
                out.flush();
                if (verbose) {
                    String[] requestArray = request.split("\n");
                    for (String string : requestArray) {
                        System.out.println("> " + string);
                    }
                    System.out.println("> ");
                }
                String line = null;
                while ((line = in.readLine()) != null) {
                    if (line.equals("{")) {
                        isBody = true;
                    }
                    if (line.startsWith("location: ") || line.startsWith("Location: ")) {
                        path = line.split(": ")[1];
                    }
                    if (line.contains("200 OK")) {
                        isOK = true;
                    }
                    if (verbose) {
                        if (isBody) {
                            System.out.println(line);
                        } else {
                            System.out.println("< " + line);
                        }
                    } else if (isBody) {
                        System.out.println(line);
                    }
                    if (line.isEmpty() && !isOK) {
                        break;
                    }
                }
                if (isBody) {
                    isLocation = false;
                    break;
                }
                count++;
            } while (isLocation && (count < 5));

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIsLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }
}
