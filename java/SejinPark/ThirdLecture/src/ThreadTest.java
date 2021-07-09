import java.util.Random;

// Runnable의 경우 run() 매서드에 대한 구현이 필요함
class Car implements Runnable {                       //implements로 보아 Runnable은 인터페이스다

    String name;
    private int sleepTime;
    private final static Random generator = new Random();  //난수를 발생시킬때는 아예 Random클래스로
                                                           //객체를 만들어 사용한다.
    public Car(String name) {
        this.name = name;
        // Random 클래스로 만든 객체에 nextInt() 매서드를 통해서도 랜덤값을 생성할 수 있다.
        sleepTime = generator.nextInt(3000) + 3000;
    }

    // 스레드를 돌릴땐 무조건 이 run() 부분을 구동시키게 되어있다.
    // 매우 중요하니 이 run()을 반드시 기억해두자!
    @Override
    public void run() {
        // try라는 키워드를 적는 경우는 I/O 나 특정한 이벤트,
        // 인터럽트 등등이 발생하는 경우에 작성하게 됨
        // 이 녀석은 에러를 유발할 수도 있다! 를 암시함
        try {
            Thread.sleep(sleepTime);          //Thread클래스를 쓸땐 우선 인터럽트나 에러가 발생할 수 있기
        } catch (InterruptedException e) {    //떄문에 우선 try키워드안에 쓰고
                                              //에러가 생길것같은 부분을 catch에 적어준다.
                                              //Tread.sleep()은 프로세스를 진행시키고 어느시간동안
                                              //정지시키는 메소드다.

            // 정말 에러가 발생했다면 여기로 오게 됩니다.
            // 물론 Thread.sleep()에서 에러가 발생할 일은 99.999999999999999%로 없습니다.
            System.out.println("출력도 안 될 것이고 에러가 발생할 일이 없습니다!");
        }

        System.out.println(name + "이 경주를 완료하였습니다!");
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Car("Ferrari"));
        Thread t2 = new Thread(new Car("Spyder 918"));
        Thread t3 = new Thread(new Car("Maserati MC20"));

        t1.start();                    //.start()와 .run()의 차이점
        t2.start();                    //.start()는 순서가 무작위로 출력된다
        t3.start();

        t3.run();                      //.run()은 순차적으로만 출력된다
        t2.run();
        t1.run();
    }
}