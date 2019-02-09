package threadpool;
/**
 * threadpool interface: include three parts, first is the execute
 */
public interface ThreadPool {
    void execute(Task task);
    void addWorkers(int num);
    void shutDown();
    void removeWorkers(int num);
    int getSize();
}
