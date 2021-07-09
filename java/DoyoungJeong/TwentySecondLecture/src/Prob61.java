import java.math.BigInteger;

class ThreadManager {
    Thread[] calThr;
    final static BigInteger START = BigInteger.ONE;
    //START의 값이 1이지만, 천억까지 증가하니 빅인티저로 설정해주어야한다.
    final static BigInteger END = new BigInteger("6000");
    final static int THREAD_NUM = 4;
    final static int[] OPTION_NUM = {4, 6, 7, 12};

    ThreadManager() {
        calThr = new Thread[THREAD_NUM];

        for(int i=0; i<THREAD_NUM; i++) {
            calThr[i] = new Thread(new DistributedThread(START, END, i, OPTION_NUM[i]));
        }
    }
    public void calcEachThread() throws InterruptedException {
        calcEachThreadStart();
        calcEachThreadJoin();
    }
    public void calcEachThreadStart() {
        for(int i=0; i<THREAD_NUM; i++) {
            calThr[i].start();
            //.run()은 thread들이 순차적으로 계산이 되지만, 
            //.start()는 thread들이 cpu의 지시대로 critical section에 접근하면서 무작위로 계산이 진행된다!
            //.run()과 .start()의 작동이 왜 다른건지 궁금합니다!
        }
    }
    public void calcEachThreadJoin() throws InterruptedException {
        for(int i=0; i<THREAD_NUM; i++) {
            calThr[i].join();
        }
        //.join()은 다른 Thread의 계산이 끝나고 cpu로부터 작업을 할당 받을 수 있게 기다리게하는것이다.
        //데이터의 무결성을 보장하는 중요한 메소드이다!
    }

}
class DistributedThread implements Runnable{
    BigInteger start;
    BigInteger end;
    int threadIdx;
    int option;
    BigInteger localSum;
    static BigInteger totalSum;
    //static을 써줘야 전역으로 다른 클래스, 객체 안에서 값을 공유하며 계산이된다!

    DistributedThread(BigInteger start, BigInteger end, int threadIdx, int option) {
        this.start = start;
        this.end = end;
        this.threadIdx = threadIdx;
        this.option = option;

        localSum = BigInteger.ZERO;
        totalSum = BigInteger.ZERO;
    }
    public synchronized void addAll() {
        totalSum = totalSum.add(localSum);
    }

    @Override
    public void run() {
        for(BigInteger i = start; i.compareTo(end) == -1; i = i.add(BigInteger.ONE)) {
        //i를 ()안의 값과 compareTo해서 i가 작으면 -1, 같으면 ==, 크면 1을 출력한다.

            if(i.mod(new BigInteger(String.valueOf(option))).compareTo(BigInteger.ZERO) == 0) {
            //option으로 들어온 값은 int이기 때문에 빅인티저인 i와 비교하려면 new BigInteger를 통해 i와 같은 빅인티저 형태로 만들어주어야한다!
            //mod연산은 빅인티저에서 쓰이는 나머지 연산이다.
            //(String.valueOf(option))은 int를 BigInteger로 바꾸기 위해 쓰이는것 같은데 정확히 무슨뜻이지??

                System.out.println(threadIdx + "번째 스레드의 계산, " + option + "의 배수는 " + i);

                localSum = localSum.add(i);
            }

        }
        System.out.println(threadIdx + "번째 Thread 계산의 합 : " + localSum);
        //totalSum = totalSum.add(localSum);
        addAll();

        System.out.println("총 합은 : " + totalSum);
    }

}


public class Prob61 {
    public static void main(String[] args) throws InterruptedException {
        ThreadManager tm = new ThreadManager();
        tm.calcEachThread();

    }
}
