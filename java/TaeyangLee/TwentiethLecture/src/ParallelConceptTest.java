class ParallelThread implements Runnable{
    private static int[] paralletlProcessingArr;
    final int MAX = 4;
    final int MAX_LOOP = 1000000000;
    private int threadLocalIdx;

    public ParallelThread(int threadLocalIdx){
        this.threadLocalIdx = threadLocalIdx;
        paralletlProcessingArr = new int[MAX];
        for(int i = 0 ; i <MAX; i ++){
            paralletlProcessingArr[i] = 1;
        }
    }
    @Override
    public void run() {
      for(int i = 0; i <MAX_LOOP ; i++){
          paralletlProcessingArr[threadLocalIdx]++;
          paralletlProcessingArr[threadLocalIdx]--;
      }
    }
    public static int[] getParalletlProcessingArr() {
        return paralletlProcessingArr;
    }
}

public class ParallelConceptTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("지금부터 병렬처리를 시작합니다 !");
        Thread[] pt = new Thread[4];
         for(int i =0; i < 4; i ++){
             pt[i] = new Thread(new ParallelThread(i));
            pt[i].start();
            pt[i].join();
         }
         for(int i = 0; i < 4; i++){
             System.out.println("최종결과 : "+ParallelThread.getParalletlProcessingArr()[i]);
         }


    }
}
