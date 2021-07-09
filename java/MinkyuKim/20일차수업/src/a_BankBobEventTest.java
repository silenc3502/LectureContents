class Bank {
    // 만 단위로 10억임
    //++ money는 크리티컬섹션 = 스레드가 동시다발적으로 접근할 수 있는 데이터
    //++ 쉴드를 쳐서 한번에 한번씩만 접근할 수 있도록 해야함.
    //++ 쉴드는 메서드에 치는데, 실제 계산이 이루어지는 부분에 쉴드를 치면 됨. 아래에서는  this.(m+money) (m-money) 부분에
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //++ try? catch? InterruptedException? printStackTrace?
    public void plusMoney(int plus) {
        int m = this.getMoney();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setMoney(m + plus);
    }
    public void minusMoney(int minus) {
        int m = this. getMoney();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setMoney(m - minus);
    }
}
//++ Thread안에는 runnalbe라는 것이 있고, native라는 것을 통해 c언어를 호출함.
//++ run의 target은 runnable target으로 세팅이 되어있음. target으로 시작을 하게 됨.
//++ run만 만들어주면 알아서 처리를 해줌
class FirstThread extends Thread {
    public  void run() {
        for (int i = 0; i < 1000; i++) {
            a_BankBobEventTest.myBank.plusMoney(1000);
            System.out.println("plusMoney(1000) = " + a_BankBobEventTest.myBank.getMoney());
        }
    }

}
class SecondThread extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            a_BankBobEventTest.myBank.minusMoney(1000);
            System.out.println("minusMoney(1000) = " + a_BankBobEventTest.myBank.getMoney());
        }
    }
}
public class a_BankBobEventTest {

    public static Bank myBank = new Bank();

    public static void main(String[] args) {
        System.out.println("원금" + myBank.getMoney());

        FirstThread first = new FirstThread();
        SecondThread second = new SecondThread();

        first.start();
        second.start();


    }
}
