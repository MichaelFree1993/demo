package concurrent;

import java.util.concurrent.Exchanger;

public class ExchanegeTest {
    private static Exchanger exchanger = new Exchanger();

    public static void main(String[] args){
        //创建两个线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String A = "thread A";
                try{
                exchanger.exchange(A);
                System.out.println(A);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String B = "thread B";
                try{
                    exchanger.exchange(B);

                    System.out.println(B );
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
