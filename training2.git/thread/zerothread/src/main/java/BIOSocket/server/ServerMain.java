package BIOSocket.server;


/**
 * Created by gongxijun on 16-3-24.
 */
public class ServerMain {

    public static void main(String[] args) {
        BIOServerSocket bioServerSocket = new BIOServerSocket(9999);
        Thread serverThread = new Thread(bioServerSocket);
        serverThread.start();
    }
}
