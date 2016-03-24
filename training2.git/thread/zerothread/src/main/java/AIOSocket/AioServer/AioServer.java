package AIOSocket.AioServer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by gongxijun on 16-3-24.
 */

public class AioServer {

    static private Logger logger;

    static {

        logger = LoggerFactory.getLogger(AioServer.class);
    }

    private static Charset charset = Charset.forName("UTF-8");
    private static CharsetEncoder encoder = charset.newEncoder();


    static AsynchronousChannelGroup group;
    static AsynchronousServerSocketChannel server;

    public static void main(String[] args) throws Exception {


        group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
        server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress("0.0.0.0", 8013));

        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {

                server.accept(null, this); // 接受下一个连接

                try {

                    String now = new Date().toString();
                    ByteBuffer buffer = encoder.encode(CharBuffer.wrap(now + "\r\n"));
                    Future<Integer> f = result.write(buffer);
                    f.get();

                    ByteBuffer recbuffer = ByteBuffer.allocate(128);
                    result.read(recbuffer);

                    logger.info(new String("recives fom clients: "+recbuffer.array()));
                    logger.info(String.format("sent to client: %s", now));
                    result.close();

                } catch (InterruptedException e) {
                    logger.info(String.format("InterruptedException  %s", e));
                } catch (ExecutionException e) {
                    logger.info(String.format("ExecutionException  %s", e));
                } catch (IOException e) {
                    logger.info(String.format("IOException  %s", e));
                }

            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
        group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}
