import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private  int count =1;
    private Lock lock = new ReentrantLock();

    public  void incremnet(){
        try{
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }
    }
    public  void decrement(){
        try{
            lock.lock();
            count--;
        }finally {
            lock.unlock();
        }
    }

    public void increment() {
        try{
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }
    }
}
