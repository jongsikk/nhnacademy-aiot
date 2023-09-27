
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
        boolean isServer = args[0].equals("-l");
        String clientId = isServer ? null : args[0];
        String host = isServer ? null : args[1];
        int port = isServer ? Integer.parseInt(args[1]) : Integer.parseInt(args[2]);

        try (ServerSocket serverSocket = isServer ? new ServerSocket(port) : null;
                Socket socket = isServer ? serverSocket.accept() : new Socket(host, port);) {
            Client client = new Client(clientId, host, port, socket);
            Server server = new Server(client);
            server.start();
            server.join();
            System.out.println(client.getId());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
