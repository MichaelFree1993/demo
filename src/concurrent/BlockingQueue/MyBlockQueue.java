package concurrent.BlockingQueue;

import concurrent.MyLock;
import java.util.concurrent.locks.Condition;

public class MyBlockQueue {
    private final Condition notFull;
    private final Condition notEmpty;
    private MyLock myLock = new MyLock();

    public MyBlockQueue(){
        notFull= myLock.getConditon();
        notEmpty = myLock.getConditon();
    }
}
