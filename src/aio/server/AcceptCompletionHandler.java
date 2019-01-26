package aio.server;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel asynchronousSocketChannel,
                          AsyncTimeServerHandler asyncTimeServerHandler){

    } 

    @Override
    public void failed(Throwable ex, AsyncTimeServerHandler asyncTimeServerHandler){

    }
}
