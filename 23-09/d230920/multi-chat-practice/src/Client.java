import java.net.Socket;

public class Client {
    String id;
    String host;
    int port;
    Socket socket;

    public Client(String id, String host, int port, Socket socket) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.socket = socket;
    }

    public String getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Socket getSocket() {
        return socket;
    }
}
