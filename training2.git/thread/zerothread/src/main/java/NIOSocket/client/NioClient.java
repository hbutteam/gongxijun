package NIOSocket.client;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;




/**
 * Created by gongxijun on 16-3-24.
 */

public class NioClient {

    private static final Logger log = Logger.getLogger(NioClient.class.getName());
    private InetSocketAddress inetSocketAddress;

    public NioClient(String hostname, int port) {
        inetSocketAddress = new InetSocketAddress(hostname, port);
    }

    /**
     * 发送请求数据
     *
     * @param requestData
     */
    public void send(String requestData) {
        try {
            SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            socketChannel.write(ByteBuffer.wrap(requestData.getBytes()));
            while (true) {
                byteBuffer.clear();
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0) {
                    byteBuffer.flip();
                    log.info("Client: readBytes = " + readBytes);
                    log.info("Client: data = " + new String(byteBuffer.array(), 0, readBytes));
                    socketChannel.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
