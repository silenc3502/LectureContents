//특정 값에 BLOCK을 걸어서 100개만 출력되는것을 확인할수있다.
import java.util.ArrayList;

public class SyncBlock1 {
    public ArrayList<Integer> mList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        SyncBlock1 syncblock1 = new SyncBlock1();

        System.out.println("Test start");

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                syncblock1.add(i);
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                syncblock1.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(syncblock1.mList.size());
        System.out.println("Test end");
    }

    public void add(int val) {
        /*code for synchronization is not needed*/
        synchronized (this) {
            if (!mList.contains(val)) {
                mList.add(val);
            }
        }
    }


}
