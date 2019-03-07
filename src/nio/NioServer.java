package nio;

public class NioServer {
    public static void main(String[] args) {
        int port = 8080;
        if(args!=null && args.length>0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (Exception e){
                port = 8080;
            }
        }

        MultiplexerTimerServer timerServer = new MultiplexerTimerServer(port);
        new Thread(timerServer,"NIO-TimeServer-001").start();
    }
}
