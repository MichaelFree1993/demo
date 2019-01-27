package concurrent;

public class Lock {

    //内部同步器
    public static class Sync{
        public static void tryLock(){

        }

        public static void releaseLock(){

        }
    }

    public static void tryLock(){
        Sync.tryLock();
    }

    public static void releaseLock(){
        Sync.releaseLock();
    }
}
