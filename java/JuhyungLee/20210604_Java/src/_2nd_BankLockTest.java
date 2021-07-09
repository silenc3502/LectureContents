public class _2nd_BankLockTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        System.out.println("First count: " + counter.getCount());
        Thread adder = new Thread(new Worker(counter, true, 1000));
        adder.start();

        Thread substracter = new Thread(new Worker(counter, false, 1000));
        substracter.start();

        adder.join();
        substracter.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
