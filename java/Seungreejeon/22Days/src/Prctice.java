class ThreadSetting implements Runnable{
    int min;
    int max;
    int Thread_idx;
    int sum;
    int option;

    public ThreadSetting(int min, int max, int thread_idx, int option) {
        this.min = min;
        this.max = max;
        Thread_idx = thread_idx;
        this.option = option;
    }

    @Override
    public void run() {
        for (; min < max; option += 2) {
            sum += option;
        }
        System.out.println(sum);
    }
}

class Somthing {
    private final int MAXTHREAD = 2;
    private final int MAXNUMTEN = 10;
    private final int MINNUM = 1;
    int option[] = {1, 2};

    Thread[] thr;

    public Somthing() {
        thr = new Thread[MAXTHREAD];

        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i] = new Thread(new ThreadSetting(MINNUM, MAXNUMTEN, i, option[i]));
        }
    }

    public void ThreadManager() throws InterruptedException {
        calcStart();
        calcJoin();
    }

    public void calcStart() {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].start();
        }
    }

    public void calcJoin() throws InterruptedException {
        for (int i = 0; i < MAXTHREAD; i++) {
            thr[i].join();
        }
    }


}
public class Prctice {
    public static void main(String[] args) throws InterruptedException {
        Somthing so = new Somthing();

        so.ThreadManager();

    }
}
