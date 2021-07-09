public class BankLockTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        System.out.println("First count: " + counter.getCount());

        Thread adder = new Thread(new Worker(counter, true, 1000));
        adder.start();

        Thread subtracter = new Thread(new Worker(counter, false, 1000));
        subtracter.start();

        adder.join();
        subtracter.join();

        System.out.println("Final count: " + counter.getCount());
    }
}