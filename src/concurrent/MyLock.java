package concurrent;

public class MyLock {

    //编写内部同步器
    public static class Sync{
        private volatile int state = 0;

        public static void tryLock(){
            
        }
    }

    //编写锁的功能函数
    public void tryLock(){
        Sync.tryLock();
    }
}
