package BIOSocket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by gongxijun on 16-3-24.
 */
public class ClientSocket {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String ip_Addr = "127.0.0.1";
    private Integer port = 6666;

    public ClientSocket(String ipaddress, Integer port) {

        this.ip_Addr = ipaddress;
        this.port = port;
    }

    public void sendMessage(int num) {

        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        String message = "hi ~~ i'm client";
        try {

            socket = new Socket(this.ip_Addr, this.port);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(String.format(" %s %d", message, num).getBytes());
            out.flush();
            int n_bytes;
            byte[] recives = new byte[1024];
            String reMessage = null ,send = null;
            if (-1 != (n_bytes = in.read(recives))) {
                reMessage = new String(recives, 0, n_bytes);
            }
            logger.info(String.format("from server: %s",reMessage));
        } catch (IOException e) {
            logger.info(String.format("IOException :", e));
        } finally {
            try {
                if (null != out) out.close();
                if (null != in) in.close();
            } catch (IOException e) {
                logger.info(String.format("IOException :", e));
            }

        }

    }

}
