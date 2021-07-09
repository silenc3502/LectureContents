import java.math.BigInteger;
class ThreadManager {
    final static int MAXTHREAD = 3; //Thread 3개 사용
    final static BigInteger START = new BigInteger("1");
    final static BigInteger END = new BigInteger("100000000000"); //1000억

    final static int EVEN = 2;
    final static int SEVEN = 7;
    final static int ELEVEN = 11;

    final static int[] OPTION_ARR = { EVEN, SEVEN, ELEVEN }; // 2,7,11로 나누기 조건

    Thread[] thr;

    public ThreadManager () {
        thr = new Thread[MAXTHREAD]; //3개로 초기화

        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i] = new Thread(new DistributedThread(START, END, i, OPTION_ARR[i])); //각 스레드마다 조건 초기화
                                                                  //각 Thread마다 객체가 다르기때문에 따로 임계 영역 X
        }
    }

    public void calcEachBigInteger () throws InterruptedException { //중계 메서드 배치
        calcEachBigIntegerStart();
        calcEachBigIntegerJoin();
    }

    public void calcEachBigIntegerStart () { //Thread 시작메서드
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].start();
        }
    }

    public void calcEachBigIntegerJoin () throws InterruptedException { //각 Thread가 끝날때까지 기다린다.
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].join();
        }
    }
}

class DistributedThread implements Runnable {
    BigInteger start;
    BigInteger end;

    int threadIdx; //Thread 번호
    int option;    //ThreadManager 클래스 조건 대입용

    static final BigInteger ONE = new BigInteger("1");

    BigInteger localSum;
    static BigInteger totalSum;

    public DistributedThread (BigInteger start, BigInteger end, int threadIdx, int option) {
        this.start = start;
        this.end = new BigInteger("10").add(BigInteger.ONE);
        this.threadIdx = threadIdx;
        this.option = option;

        localSum = BigInteger.ZERO;
        totalSum = BigInteger.ZERO;

    }

    private synchronized void addAll () {
        totalSum = totalSum.add(localSum);
    }

    @Override
    public void run() { //interface 구현

        for (BigInteger i = start; i.compareTo(end) == -1; i = i.add(ONE)) {

            /* DEBUG 메시지
            System.out.println("threadIdx: " + threadIdx +
                    ", BigInteger 기반 비교를 시작합니다. 현재 i = " + i +
                    ", start = " + start + ", end = " + end +
                    ", i + ONE = " + i.add(ONE)); */

            // if (i % option == 0) {
            if (
                    (i.mod(new BigInteger(String.valueOf(option))).
                            compareTo(BigInteger.ZERO)
                    ) == 0
            ) {
//                 DEBUG 메시지
//                System.out.println("threadIdx: " + threadIdx +
//                        ", option: " + option +
//                        ", 내가 찾는 숫자는: " + i);
                localSum = localSum.add(i);

//                 System.out.println("threadIdx: " + threadIdx + ", sum = " + localSum);
            }
        }

        addAll();

        System.out.println("totalSum = " + totalSum);
    }
}

public class Prob61 {
    public static void main(String[] args) throws InterruptedException {
        ThreadManager tm = new ThreadManager();

        tm.calcEachBigInteger();
    }
}
// 2 4 6 8 10  12 14 16 18 20  22 24 26 28 30
// 32 x 7 + 16 => 224 + 16 = 240