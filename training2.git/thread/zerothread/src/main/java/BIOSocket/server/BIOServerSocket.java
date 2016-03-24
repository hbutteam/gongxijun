package BIOSocket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gongxijun on 16-3-24.
 */

public class BIOServerSocket implements Runnable {

    private Integer BlindPort = 9999; //default
    private static int clietId = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public BIOServerSocket(Integer port) {
        this.BlindPort = port;
    }

    private void sendMessage(Socket socket) {

        InputStream in = null;
        OutputStream out = null;
        int n_byte;
        byte[] rebuff = new byte[512];
        String  client_message = null, sendmessage = "hi ～  i'm server! ";
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            if (-1 != (n_byte = in.read(rebuff))) {
                client_message = new String(rebuff, 0, n_byte);
            }
            logger.info(String.format("form client: %s", client_message));
            out.write(sendmessage.getBytes());
            out.flush();

        } catch (IOException e) {
            logger.info(String.format("IOException %s", e));

        } finally {

         /*   try {
                if(null != out)  out.close();
                if(null != in) in.close();
            } catch (IOException e) {
                logger.info(String.format("IOException %s", e));
            }
        }*/
        }
    }
    @Override
    public void run() {
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(this.BlindPort);
            while (true) {
                socket = serverSocket.accept(); //listen
                //send message
                sendMessage(socket);
            }
        } catch (IOException e) {
            logger.info(String.format("IOException %s", e));
        }
    }
}
