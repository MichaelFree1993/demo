package nio;

public class NioClient {
    public static void main(String[] args) {
        int port = 8080;
        try {
            if (args != null && args.length > 0) {
                port = Integer.valueOf(args[0]);
            }
        } catch (Exception e) {
            //对port采用默认值
        }

        //启动客户端线程
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient_001").start();
    }
}
