import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b_Counter {
    private int count = 1;
    // Thread를 사용할 때 Lock을 걸려면
    // ReentrantLock을 사용하여 재진입이 가능한 형태로 만들어줘야 한다.
    private Lock lock = new ReentrantLock();

    public void increment () {
        try {
            lock.lock();
            count++;
        } finally {
            // 성공적으로 처리했던, 실패를 했던
            // finally는 무조건 실행된다.
            // 그러므로 내부에서 문제가 생겨도 Lock은 해제를 한다는 뜻
            // ex) 화장실에서 문 잠그고 죽음 ???
            lock.unlock();
        }
    }
    public void decrement () {
        try {
            //++ 증감시키는 부분이 크리티컬섹션이기 때문에 락을 걸어둠
            //++ 락을 걸어둠으로써 데이터의 무결성이 보장됨(무결성이 보장되므로, 쓰레드를 마음대로 써도됨.)
            //++ 락객체 자체가 쉴드에 해당됨
            lock.lock();
            count--;
        } finally {
            lock.unlock();
        }
    }
    public int getCount () {
        return count;
    }
}