package NIOSocket.client;

/**
 * Created by gongxijun on 16-3-24.
 */
public class ClientMain {

    public static void main(String[] args) {
        String hostname = "localhost";
        String requestData = "Actions speak louder than words!";
        int port = 980;
        new NioClient(hostname, port).send(requestData);
    }

}
