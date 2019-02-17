package threadpool;

public class Task implements Runnable{

    @Override
    public void run(){
        System.out.println("do task");
    }
}
