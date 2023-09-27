import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server extends Thread {
    static List<Server> serverList = new LinkedList<>();
    Client client;
    BufferedWriter writer;

    public Server(Client client) {
        this.client = client;
        serverList.add(this);
    }

    public void send(String message) throws IOException {
        writer.write(message + "\n");
        writer.flush();
    }

    public void start() {
        try (BufferedReader socketReader = new BufferedReader(
                new InputStreamReader(client.getSocket().getInputStream()));
                BufferedWriter socketWriter = new BufferedWriter(
                        new OutputStreamWriter(client.getSocket().getOutputStream()));
                BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter terminalWriter = new BufferedWriter(new OutputStreamWriter(System.out));) {
            this.writer = writer;
            while (!Thread.currentThread().isInterrupted()) {
                String line = socketReader.readLine();
                for (Server server : serverList) {
                    server.send(line);
                }
            }
            // Thread receiver = new Thread(new IOThread(socketReader, terminalWriter));
            // Thread sender = new Thread(new IOThread(terminalReader, socketWriter));
            // receiver.start();
            // sender.start();

            // receiver.join();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
