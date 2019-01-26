package aio.server;

import aio.server.AcceptCompletionHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable{
    private int port;
    private CountDownLatch latch;
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    /**构造函数里处理IP和端口连接*/
    public AsyncTimeServerHandler(int port){
        this.port=port;
        try{
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("the time server is start in port : "+ port);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void run(){
        latch = new CountDownLatch(1);
        doAccept();
    }

    private void doAccept(){
        /**弄清楚accept如何执行的*/
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }

}
