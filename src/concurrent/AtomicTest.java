package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        List<Thread> threadList = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ; i<1000;i++){
                        atomicTest.unsafeCount();
                        atomicTest.safeCount();
                    }
                }
            });
            threadList.add(thread);
            thread.start();
        }

        for(Thread thread : threadList){
            try{
                thread.join();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.println(atomicTest.i);
        System.out.println(atomicTest.atomicInteger.get());
    }


    //同步计数
    public void safeCount() {
        atomicInteger.getAndIncrement();
    }

    //非同步计数
    public void unsafeCount() {
        i++;
    }
}
