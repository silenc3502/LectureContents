import java.math.BigInteger;

// 숫자가 굉장히 커지므로 BigInteger를 사용하도록 한다.
// 1 ~ 1000억까지 짝수들의 합을 계산하는 스레드 1개
// 1 ~ 1000억까지 7의 배수들의 합을 계산하는 스레드 1개
// 1 ~ 1000까지 11의 배수를 곱하는 스레드 1개
// 총 3개의 스레드를 만들어서 이들 각각의 결과를 출력하고
// 이 결과의 합을 출력하도록 프로그래밍 해보자!

class ThreadManager {
    final static int MAXTHREAD = 3;
    // 짝수 합, 7의 배수 합, 11 배수 곱을 계산할 각각의 스레드
    final static BigInteger START = new BigInteger("1");
    // 시작 값 : 1 (이유 : 1부터 1000억까지의 수 중에서 계산값을 구함)
    final static BigInteger END = new BigInteger("100000000000");
    // 끝 값 : 100000000000 (이유 : 1부터 1000억까지의 수 중에서 계산값을 구함)

    final static int EVEN = 2;
    // 짝수
    final static int SEVEN = 7;
    // 7의 배수
    final static int ELEVEN = 11;
    // 11의 배수

    final static int[] OPTION_ARR = { EVEN, SEVEN, ELEVEN };
    // 옵션 배열 = { 2 , 7 , 11 }

    Thread[] thr;

    public ThreadManager () {
        thr = new Thread[MAXTHREAD];
        // 스레드는 총 3개

        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i] = new Thread(new DistributedThread(START, END, i, OPTION_ARR[i]));
            // thr[0] = new Thread ( new DistributedThread(1, 30.add(1), 0, EVEN ))
            // thr[1] = new Thread ( new DistributedThread(1, 30.add(1), 1, SEVEN ))
            // thr[2] = new Thread ( new DistributedThread(1, 30.add(1), 2, ELEVEN ))
        }
    }

    public void calcEachBigInteger () {
        calcEachBigIntegerStart();
    }

    public void calcEachBigIntegerStart () {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].start();
            // 스레드 3개 시작
        }
    }

    public void calcEachBigIntegerJoin () throws InterruptedException {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].join();
            // join을 통해 먼저 끝나는 스레드가 있다면 대기
        }
    }
}

class DistributedThread implements Runnable {
    // Runnable 인터페이스
    // run( ) 매서드만 채워주면 Runnable 인터페이스 구현은 간단하다.
    // Thread 상속받은 클래스처럼 start( )매서드는 없다.
    // 별도로 Thread 생성,구현한 Runnable 인터페이스를 인자로 넘겨주어야 한다.

    BigInteger start;
    BigInteger end;

    int threadIdx;
    int option;

    static final BigInteger ONE = new BigInteger("1");

    BigInteger localSum;
    static BigInteger totalSum;

    public DistributedThread (BigInteger start, BigInteger end, int threadIdx, int option) {
        this.start = start;
        //this.end = end.add(BigInteger.ONE);
        this.end = new BigInteger("30").add(BigInteger.ONE);
        // end = 100000000000 값이 너무 커서 계산 확인이 안된다.
        // end = 30으로 재설정
        // 30.add(1)

        this.threadIdx = threadIdx;
        this.option = option;

        localSum = BigInteger.ZERO;
        totalSum = BigInteger.ZERO;
    }

    private synchronized void addAll () {
        totalSum = totalSum.add(localSum);
//        totalSum += localSum; 이 안된다.
        // totalSum = totalSum + localSum
    }

    @Override
    public void run() {

        for (BigInteger i = start; i.compareTo(end) == -1; i = i.add(ONE)) {
//             compareTo 란 무엇인가 ?
//            두개의 값을 비교하여 int값으로 반환해주는 함수이다.
            // 문자열 비교와 숫자의 비교 두 방식이 존재하며,
            // 숫자의 비교 : 크다(1), 같다(0), 작다(-1)
            // 문자열 비교 : 같다(0), 그 외 양수 / 음수값

            // 기준값.compareTo(비교대상)
            // 즉 i.compareTo(end) == -1 이란
            // i 값이 end값과 비교하였을때 작을 때
            // i < end와 같은 의미이지만, BigInteger에서는 쓸 수 없다.

            // i = i.add(ONE) 는 i++와 의미가 같다.



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
//                 mod는 무엇인가 ?
                // 나머지 연산자(Modulus Operator)
                //i.mod(new BigInteger(String.valueOf(option))).compareTo(BigInteger.ZERO)) == 0
                // 만약 (i % ( EVEN.compareTo(0) )) == 0
                // (i % ( 2.compareTo(0) )) == 0
                // 계산식을 어떻게 생각하면 좋을지 이해가 안갑니다..
                // 이 부분 설명 한번만 부탁드립니다.


                /* DEBUG 메시지
                System.out.println("threadIdx: " + threadIdx +
                        ", option: " + option +
                        ", 내가 찾는 숫자는: " + i); */
                localSum = localSum.add(i);

                // System.out.println("threadIdx: " + threadIdx + ", sum = " + sum);
            }
        }

        addAll();

        System.out.println("totalSum = " + totalSum);
    }
}

public class Quiz61 {
    public static void main(String[] args) {
        ThreadManager tm = new ThreadManager();

        tm.calcEachBigInteger();
    }
}
// 2 4 6 8 10  12 14 16 18 20  22 24 26 28 30
// 32 x 7 + 16 => 224 + 16 = 240