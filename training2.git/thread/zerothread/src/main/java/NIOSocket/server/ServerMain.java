package NIOSocket.server;

/**
 * Created by gongxijun on 16-3-24.
 */
public class ServerMain {
    public static void main(String[] args) {
        NioServer server = new NioServer("127.0.0.1", 9990);
        server.start();
    }
}
