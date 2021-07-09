public class c_Worker implements Runnable {
    private b_Counter counter;
    private boolean increment;
    private int count;

    public c_Worker(b_Counter counter, boolean increment, int count) {
        this.counter = counter;
        this.increment = increment;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            if (increment) {
                this.counter.increment();
                System.out.println("I'm increment");
            } else {
                this.counter.decrement();
                System.out.println("I'm decrement");
            }
        }
    }
}