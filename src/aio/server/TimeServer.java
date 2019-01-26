package aio.server;

import aio.server.AsyncTimeServerHandler;

public class TimeServer {

    public static void main(String[] args){
        int port = 8080;
        if(args!=null&&args.length>0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException ex){
                throw ex;
            }
        }

        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "thread-001").start();
    }
}
