public class Review20_1 {
    private int count = 1;
        // Thread를 사용할 때 Lock을 걸려면
        // ReentrantLock을 사용하여 재진입이 가능한 형태로 만들어줘야 한다.
        private Lock lock = new ReentrantLock();

        public void increment () {
            try {
                lock.lock();
                count++;
            } finally {
                // 성공적으로 처리했던, 실패를 했던 finally는 무조건 실행된다.
                // 그러므로 내부에서 문제가 생겨도 Lock은 해제를 한다는 뜻
                // 이걸로 스래드 여러 개 돌릴 때 값 개판나는 거 방지할 수 있음
                lock.unlock();
            }
        }
        public void decrement () {
            try {
                lock.lock();
                count--;
            } finally {
                lock.unlock();
            }
        }
        public int getCount () {
            return count;
        }
}
