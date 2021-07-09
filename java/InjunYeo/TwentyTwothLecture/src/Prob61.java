import java.math.BigInteger;

class ThreadManager{
    final static int MAXTHREAD =3;
    final static BigInteger START = new BigInteger("1");
    final static BigInteger END = new BigInteger("100000000000");

    final static int EVEN = 2;
    final static int SEVEN = 7;
    final static int ELEVEN = 11;

    final static int[] OPTION_ARR = {EVEN,SEVEN,ELEVEN};

    Thread[] thr;

    public ThreadManager(){
        thr = new Thread[MAXTHREAD];

        for(int i=0;i<MAXTHREAD;i++){
            thr[i] = new Thread(new DistributedThread(START,END,i,OPTION_ARR[i]));
        }
    }

    public void calcEachBigInteger() throws InterruptedException {
        calcEachBigIntegerStart();
        calcEachBigIntegerStartJoin();
    }

    public void calcEachBigIntegerStart() {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].start();

        }
    }
    public void calcEachBigIntegerStartJoin() throws InterruptedException {
            for(int i =0;i<MAXTHREAD;i++){
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

    public DistributedThread(BigInteger start, BigInteger end, int threadIdx,int option){

        this.start = start;
        //this.end = end;
        this.end = new BigInteger("30");

        this.threadIdx = threadIdx;
        this.option = option;

        localSum = BigInteger.ZERO;
        totalSum = BigInteger.ZERO;
    }

    private synchronized void addAll(){
        totalSum = totalSum.add(localSum);
    }

    @Override
    public void run() {
        //BigInteger를 비교할때는 compareTo를 사용하자.
        for(BigInteger i = start;i.compareTo(end) <= 0;i = i.add(ONE)){
            /* 디버깅 메시지
            System.out.println("threadIdx: "+threadIdx +", BigInteger 기반 비교를 시작합니다."+i+
                    ", start = "+start+", end = "+end+", i+ONE = "+i.add(ONE));
             */

            //if(i%option==0)
            if( (i.mod(new BigInteger(String.valueOf(option))).
                    compareTo(BigInteger.ZERO))
                    == 0){
                /*
                System.out.println("threadIdx : "+threadIdx+", option: "+option+",내가찾는 숫자는 : "+i );

                 */

                localSum = localSum.add(i);

                //System.out.println("threadIdx : "+threadIdx+", sum = "+localSum);
            }


        }

        addAll();

        System.out.println(totalSum);
    }
}

public class Prob61 {
    public static void main(String[] args) throws InterruptedException {
        ThreadManager tm = new ThreadManager();

        tm.calcEachBigInteger();

    }
}
