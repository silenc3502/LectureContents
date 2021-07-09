//this가 아닌 object1과 object2 객체를 만들어 this가 아닌 동시에 lock 걸려야 하는 부분을 따로 지정해 줄 수 있다!!!

import java.util.HashMap;

public class SyncBlock3 {
    private HashMap<String, String> abMap = new HashMap<>();
    private HashMap<String, String> cdMap = new HashMap<>();

    private final Object object1 = new Object();
    private final Object object2 = new Object();

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
        synchronized (object1) {
            abMap.put(key, value);
        }
    }

    public String getC(String key) {
        synchronized (object1) {
            return cdMap.get(key);
        }
    }
    public void putCD(String key, String value) {
        synchronized (object2) {
            abMap.put(key, value);
        }
    }

    public String getA(String key) {
        synchronized (object2) {
            return cdMap.get(key);
        }
    }
}