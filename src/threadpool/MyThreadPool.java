package threadpool;

import java.util.LinkedList;
import java.util.List;

public class MyThreadPool implements ThreadPool{

    private static final int MAX_WORKER_NUMBER = 10;

    private static final int MIN_WORKER_NUMBER = 1;

    private static final int DEFAULT_WORKER_NUMBER = 5;

    private List<Worker> workerList;

    //一般用阻塞队列更专业
    private LinkedList<Task> taskLinkedList;

    //工作线程数量
    private int countNum;

    //构造函数
    public MyThreadPool(List<Worker> workerList, LinkedList<Task> taskLinkedList) {
        this.workerList = workerList;
        this.taskLinkedList = taskLinkedList;
    }

    public void initialWorker(){

    }

    @Override
    public void execute(Task task) {
        if (task != null) {
            synchronized (taskLinkedList) {
                taskLinkedList.add(task);
                taskLinkedList.notify();
            }
        }
    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorkers(int num) {

    }

    @Override
    public int getSize(){
        return countNum;
    }

    @Override
    public void shutDown(){
        for(Worker worker : workerList){
            worker.shutDown();
        }
    }

    public class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Task task = null;
                synchronized (taskLinkedList) {
                    while (taskLinkedList.isEmpty()) {
                        try {
                            taskLinkedList.wait();
                        } catch (Exception ex) {

                        }
                    }
                    task = taskLinkedList.removeFirst();
                }
                if (task != null) {
                    //需要处理异常
                    task.run();
                }
            }
        }

        public void shutDown() {
            running = false;
        }
    }
}
