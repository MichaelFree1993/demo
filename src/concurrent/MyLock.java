package concurrent;

import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;

public class MyLock {

    //内部同步器
    public static class Sync {
        private volatile int state = 0;
        private Thread exclusiveOwnerThread;
        private Condition condition;
        private Unsafe unsafe ;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Thread getExclusiveOwnerThread() {
            return exclusiveOwnerThread;
        }

        public void setExclusiveOwnerThread(Thread exclusiveOwnerThread) {
            this.exclusiveOwnerThread = exclusiveOwnerThread;
        }

        public boolean tryLock(int num) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        public boolean releaseLock(int num) throws Exception {
            if (getState() == 0) {
                throw new Exception("state is wrong");
            }
            int i = getState() - num;
            setState(i);
            if (i == 0) {
                setExclusiveOwnerThread(null);
                return true;
            } else {
                return false;
            }
        }

        public boolean compareAndSetState(int a, int b){
            return unsafe.compareAndSwapInt(this,state,a,b);
        }

        public Condition getCondition(){
            return condition;
        }
    }

    //新建同步队列器对象
    Sync sync = new Sync();

    public boolean tryLock(int num) {
        return sync.tryLock(num);
    }

    public boolean releaseLock(int num) throws Exception {
        return sync.releaseLock(num);
    }
}
