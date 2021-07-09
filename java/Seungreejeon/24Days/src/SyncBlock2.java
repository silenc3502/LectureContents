//LOCK의 주체가 this이기때문에 this로 걸려있는 동기화 block은 해당 lock이 풀릴때까지 대기해야한다.
import java.util.HashMap;

public class SyncBlock2 {
    private HashMap<String, String> abMap = new HashMap<>();
    private HashMap<String, String> cdMap = new HashMap<>();

    public static void main(String[] args) {
        SyncBlock2 syncBlock2 = new SyncBlock2();
        System.out.println("Test start");

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncBlock2.putAB("a", "b");
                syncBlock2.getC("c");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncBlock2.putCD("c", "d");
                syncBlock2.getA("a");
            }
        }).start();
        System.out.println("Test end");
    }

    // this에 걸려버리면 자체 LOCK이 풀릴때까지 대기해야한다.
    // 정작 LOCK이 필요한건 같은 hasmap을 동시에 접근하는경우 putAB와 getA 또 putCD getC가 각각 LOCK 이걸려야 효율적이다.
    public void putAB(String key, String value) {
        synchronized (this) {
            abMap.put(key, value);
        }
    }

    public String getC(String key) {
        synchronized (this) {
            return cdMap.get(key);
        }
    }
    public void putCD(String key, String value) {
        synchronized (this) {
            abMap.put(key, value);
        }
    }

    public String getA(String key) {
        synchronized (this) {
            return cdMap.get(key);
        }
    }
}