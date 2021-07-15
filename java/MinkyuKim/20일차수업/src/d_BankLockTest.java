public class d_BankLockTest {
    public static void main(String[] args) throws InterruptedException {
        b_Counter counter = new b_Counter();
        System.out.println("First count: " + counter.getCount());

        Thread adder = new Thread(new c_Worker(counter, true, 1000));
        adder.start();

        Thread subtracter = new Thread(new c_Worker(counter, false, 1000));
        subtracter.start();

        adder.join();
        subtracter.join();

        System.out.println("Final count: " + counter.getCount());
    }
}