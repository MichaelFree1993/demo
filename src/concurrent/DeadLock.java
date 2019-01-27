package concurrent;

public class DeadLock {
    private static final Object A = new Object();
    private static final Object B = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        doSomething("threadA1");
                        Thread.sleep(100);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    synchronized (B) {
                        doSomething("threadA2");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    try {
                        doSomething("threadB1");
                        Thread.sleep(100);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    synchronized (A) {
                        doSomething("threadB2");
                    }
                }

            }
        });

        thread1.start();
        thread2.start();
    }

    public static void doSomething(String string) {
        System.out.println(string);
    }
}
