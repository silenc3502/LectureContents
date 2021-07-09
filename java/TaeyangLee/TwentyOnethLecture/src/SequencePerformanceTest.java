public class SequencePerformanceTest {
    final static int ZERO = 0;
    final static int END5 = 1000000000;
    final static int START5 = 800000001;
    final static int END4 = 800000000;
    final static int START4 = 600000001;
    final static int END3 = 600000000;
    final static int START3 = 400000001;
    final static int END2 = 400000000;
    final static int START2 = 200000001;
    final static int END = 200000000;
    final static int START = 1;
    final static double COEFFICIENT = Math.pow(10, -15);
    final static double DEG2RAD = 180.0;

    public static void main(String[] args) {
        double sum = ZERO;
        double sum2 = ZERO;
        double sum3 = ZERO;
        double sum4 = ZERO;
        double sum5 = ZERO;

        PerformanceUtil.performanceCheckStart();

        for(int i = START; i <= END; i++) {
            // Math.sin() 자체가 연산량이 많다.
            // 그래서 스레드를 활용했을때와 활용하지 않았을때의 차이를 보기에 좋다.
            // 삼각함수 연산을 도입해서 스레드 없이 순차 처리하였을때
            // 얼마나 오래걸리는지를 체크해보고
            // 실제 스레드를 도입했을때 성능이 대폭 상승하는 것을 보면 됩니다.
            sum += (i * (COEFFICIENT * i)) * Math.sin(i * Math.PI / DEG2RAD);
        }
        for(int i = START2; i <= END2; i++) {
            sum2 += (i * (COEFFICIENT * i)) * Math.sin(i * Math.PI / DEG2RAD);
        }
        for(int i = START3; i <= END3; i++) {
            sum3 += (i * (COEFFICIENT * i)) * Math.sin(i * Math.PI / DEG2RAD);
        }
        for(int i = START4; i <= END4; i++) {
            sum4 += (i * (COEFFICIENT * i)) * Math.sin(i * Math.PI / DEG2RAD);
        }
        for(int i = START5; i <= END5; i++) {
            sum5 += (i * (COEFFICIENT * i)) * Math.sin(i * Math.PI / DEG2RAD);
        }
        System.out.println("sum = " + sum);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);
        System.out.println("sum5 = " + sum5);

        PerformanceUtil.performanceCheckEnd();

        //System.out.println("sum = " + sum);

        PerformanceUtil.printPerformance();
    }
}