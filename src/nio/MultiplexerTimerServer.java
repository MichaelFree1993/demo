package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimerServer implements Runnable {
    private int port;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public MultiplexerTimerServer(int port) {
        try {
            this.port = port;
            selector = Selector.open();
            //创建Channel对象
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            //这是干嘛用的？？
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            //这是干嘛用的？？
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (it.hasNext()) {
                    selectionKey = it.next();
                    it.remove();
                    try{
                        handleInput(selectionKey);
                    }catch (Exception e){
                        //关闭一些连接
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void handleInput(SelectionKey selectionKey) throws Exception{
        if(selectionKey.isValid()){
            //处理接收消息
            if(selectionKey.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //增加新连接到selector
                sc.register(selector, SelectionKey.OP_READ);
            }
            //处理读数据信息
            if(selectionKey.isReadable()){
                SocketChannel sc = (SocketChannel) selectionKey.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                //将读取到的数据存放在ByteBuffer中
                int readByte = sc.read(byteBuffer);
                if(readByte>0){

                }else if(readByte<0){

                }else {
                    //没有读取到数据
                }
            }
        }
    }
}
