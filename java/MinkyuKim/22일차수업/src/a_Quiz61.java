import java.math.BigInteger;

// 숫자가 굉장히 커지므로 BigInteger를 사용하도록 한다.
// 1 ~ 1000억까지 짝수들의 합을 계산하는 스레드 1개
// 1 ~ 1000억까지 7의 배수들의 합을 계산하는 스레드 1개
// 1 ~ 1000까지 11의 배수를 곱하는 스레드 1개
// 총 3개의 스레드를 만들어서 이들 각각의 결과를 출력하고
// 이 결과의 합을 출력하도록 프로그래밍 해보자!
class ThreadManager {
    //++ 스레드 개수 3개 사용
    final static int MAXTHREAD = 3;

    //++ 1부터
    final static BigInteger START = new BigInteger("1");
    //++ 1000억까지
    final static BigInteger END = new BigInteger("100000000000");

    //++ 짝수
    final static int EVEN = 2;
    //++ 7의배수
    final static int SEVEN = 7;
    //++ 11의 배수
    final static int ELEVEN = 11;

    //++ 결과값들의 합
    final static int[] OPTION_ARR = { EVEN, SEVEN, ELEVEN };

    //++ 쓰레드 배열변수선언
    Thread[] thr;

    public ThreadManager () {
        //++ 쓰레드 배열공간 3개 생성, 3개의 쓰레드
        thr = new Thread[MAXTHREAD];

        //++ 쓰레드 갯수만큼 for문 돌리고, 0~2배열에 1억, 1000억, 0~2, [2, 7, 11]   객체생성
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i] = new Thread(new DistributedThread(START, END, i, OPTION_ARR[i]));
        }
    }

    public void calcEachBigInteger () {
        calcEachBigIntegerStart();
    }

    public void calcEachBigIntegerStart () {
        //++ 쓰레드 0~2까지 실행
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].start();
        }
    }

    public void calcEachBigIntegerJoin () throws InterruptedException {
        //++ 순차적 실행(하나 종료된 이후에 실행하라)
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].join();
        }
    }
}

class DistributedThread implements Runnable {
    BigInteger start;
    BigInteger end;

    int threadIdx;
    int option;

    static final BigInteger ONE = new BigInteger("1");

    BigInteger localSum;
    static BigInteger totalSum;

    public DistributedThread (BigInteger start, BigInteger end, int threadIdx, int option) {

        //++
        this.start = start;
        // this.end = end.add(BigInteger.ONE);
        this.end = new BigInteger("30").add(BigInteger.ONE);
        //++ System.out.println(this.end);

        this.threadIdx = threadIdx;
        this.option = option;

        //++ 0값으로 초기화
        localSum = BigInteger.ZERO;
        totalSum = BigInteger.ZERO;
    }

    //++ 동기화 : 여기서 사용되는 변수들이 동기화해준다 (semi lock이라 볼 수 있다.)
    //++ 단 짧은(하나만?) 것만 동기화되는것을 보장해줄 수 있다.
    //++ 전역변수로 위에서 지정한것은 하나만(그대로 totalSum 만)을 덮어씌게되므로
    private synchronized void addAll () {
        totalSum = totalSum.add(localSum);
    }

    @Override
    public void run() {

        // compareTo의 결과가 작으면 -1, 0은 같으면, 1은 크면이라는 의미
        //++ i < end ?
        //++ i는 1~30까지 출력된다. 즉 start는 01
        //++ end는 31이다.
        for (BigInteger i = start; i.compareTo(end) == -1; i = i.add(ONE)) {
            /* DEBUG 메시지
            System.out.println("threadIdx: " + threadIdx +
                    ", BigInteger 기반 비교를 시작합니다. 현재 i = " + i +
                    ", start = " + start + ", end = " + end +
                    ", i + ONE = " + i.add(ONE)); */

            // if (i % option == 0) {
            //++ i.mod(     --> imod에서 연산된 것이 (  ~~~ ) 이다
            //++ new BigInteger(String.valueOf(option)))  맵핑? 나머지연산값 구하기.
            //++ compareTo(BigInteger.ZERO) 결과값(나머지연산값)을 0과 비교한다
            //++ ) == 0   이게 0이냐?
            System.out.println("i" + i);
            //System.out.println("s" + start);
            //System.out.println("e" + end);
            if (
                    (i.mod(new BigInteger(String.valueOf(option))).
                            compareTo(BigInteger.ZERO)
                    ) == 0
            ) {
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

public class a_Quiz61 {
    public static void main(String[] args) {
        ThreadManager tm = new ThreadManager();

        tm.calcEachBigInteger();
    }
}
// 2 4 6 8 10  12 14 16 18 20  22 24 26 28 30
// 32 x 7 + 16 => 224 + 16 = 240