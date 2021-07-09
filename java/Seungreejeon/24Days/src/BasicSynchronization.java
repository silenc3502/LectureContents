//각각의 다른방법
//synchonized는 스스로 LOCK을 건다. 가장 확실하면서 무식한 방법
//1. synchronized를 사용해 함수 자체에 LOCK을
//2. synchronized를 사용하는 대신 객체를 하나 추가로만든다.
//3. synchronized 함수는 두가지문제가 있다. 함수가 lock이 걸리고 함수를 포함한 객체(this)에 lock이 걸린다.
//   Solution : 함수 단위가 아닌 synchronized를 객체(this)에 LOCK을 건다. SyncBlock확인
public class BasicSynchronization {
    private String mMessage;

    public static void main(String[] args) {
        BasicSynchronization temp = new BasicSynchronization();

        System.out.println("Test Start");

        new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                temp.callMe("Thread_1");
            }
        }).start();

        new Thread(() ->{
            for (int i = 0; i < 100; i++) {
                temp.callMe("Thread_2");
            }
        }).start();
        System.out.println("Test end");
    }
    public synchronized void callMe(String whoCallMe) {
        mMessage = whoCallMe;

        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!mMessage.equals(whoCallMe)) {
            System.out.println(whoCallMe + " | " + mMessage);

        }

    }
}
