package concurrent;

public class ConcurrentTest {

    private static long count = 1000000000;

    public static void main(String[] args) throws Exception{
        concurrentTime(count);
        serial(count);
    }

    public static void concurrentTime(long count) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long a = 0;
                for (long i = 1; i < count; i++) {
                    a += 5;
                }
            }
        });

        long time1 = System.nanoTime();
        thread.start();
        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        //确保线程都执行完成
        thread.join();
        long time2 = System.nanoTime();
        System.out.println("the time for concurrent is： " + (time2 - time1));
    }

    public static void serial(long count){
        long time1 = System.nanoTime();
        long a = 0;
        for (long  i = 1; i < count; i++) {
            a += 5;
        }

        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long time2 = System.nanoTime();
        System.out.println("the time for serial is：     " + (time2 - time1));
    }

}
