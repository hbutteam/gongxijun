package AIOSocket.AioClient;


import java.nio.ByteBuffer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import java.util.concurrent.Future;

/**
 * Created by gongxijun on 16-3-24.
 */
public class AioClient {


    static AsynchronousSocketChannel client;
    static ByteBuffer buffer, bbf;

    public static void main(String[] args) throws Exception {


        //epoll
        client = AsynchronousSocketChannel.open();


        Future<Void> future = client.connect(new InetSocketAddress("127.0.0.1", 8013));
        future.get();

        buffer = ByteBuffer.allocate(128);
        String tmp = "it's a test !";
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {

            @Override
            public void completed(Integer result, Void attachment) {

                System.out.println("client received: " + new String(buffer.array()));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        bbf = ByteBuffer.wrap(tmp.getBytes());
        client.write(bbf, null, new CompletionHandler<Integer, Void>() {

            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("client sends: " + new String(bbf.array()));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(10000);
    }
}