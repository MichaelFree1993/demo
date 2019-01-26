package concurrent;

public class ThreadLocalDemo {
    private static final ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread");
                System.out.println(threadLocal.get());
            }
        });
        thread1.start();
        thread1.join();

        threadLocal.set("main");
        System.out.println(threadLocal.get());
    }
}

