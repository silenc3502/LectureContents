public class Thread {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread adder = new Thread(new Worker(counter, true, 1000));
        adder.start();

        Thread substacter = new Thread(new Worker(counter, false, 1000));
        substacter.start();

        adder.join();
        substacter.join();

        System.out.println("Final count : " +counter.getCount());
    }

    public static void sleep(int i) {
    }
}
