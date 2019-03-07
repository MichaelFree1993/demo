package nio;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TimeClientHandle implements Runnable {

    private int port;
    private String host;
    private Selector selector;
    private SocketChannel socketChannel;

    public TimeClientHandle(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            //打开新的SocketChannel连接
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //todo
    public void run() {

    }
}
