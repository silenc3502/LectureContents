
class MoneyBag {
    int money = 100000;

    public synchronized void add() {
        money += 1000;
        System.out.println("plus money : " + money);
    }

    public synchronized void subtract() {
        money -= 1000;
        System.out.println("minus money : " + money);
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

//    public void plusMoney(int plus) {
//        int m = this.getMoney();
//
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.setMoney(m + plus);
//    }
//
//    public void minusMoney(int minus) {
//        int m = this.getMoney();
//
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.setMoney(m - minus);
//    }
}

class oneThread extends Thread {
    int idx = 2;
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Practice1.MM.add();
            System.out.println("Thread IDX : " + idx + "  minus(1000)" + Practice1.MM.getMoney());
        }
    }
}

class twoThread extends Thread {
    int idx = 1;
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Practice1.MM.subtract();
            System.out.println("Thread IDX : " + idx + "   plus(1000)" + Practice1.MM.getMoney());
        }
    }
}

public class Practice1 {
    public static MoneyBag MM = new MoneyBag();

    public static void main(String[] args) {
        System.out.println("원금 " + MM.getMoney());

        oneThread one = new oneThread();
        twoThread two = new twoThread();

        one.start();
        two.start();

    }
}