public class HomeWork {
    //중복 방지 문제(Challenge)
    //앞서서 22번의 경우엔 난수의 범위가 0 ~ 9 였다.
    //이번에는 2개의 범위를 가지는 난수 2개를 중복없이 제어해보자!
    //하나는 5 ~ 10의 범위를 가지고 다른 하나는 7 ~ 10의 범위를 가진다.
    //22번 예제를 응용하여 풀 수 있는 문제고 다소 난이도가 높은 문제다.
    //ex) 5, 6, 7, 8, 9, 10이 모두 출력되어야 하고 또한 7, 8, 9, 10이 출력되어야 한다.
    //    여기서 중복이 발생하면 안됨

    public static void main(String[] args) {
        final int BIN = 1;

        int testBit = 0;
        int randNum;

        for (int i = 0; i< 10; i++ ) {
            randNum = (int)(Math.random() *10);

            while ((testBit & (BIN << randNum)) != 0) {

                randNum = (int)(Math.random() * 10);
            }

            System.out.printf("randNum = %d\n", randNum);  //중복되지 않은 while문 randNum 출력

            // 실제 자리수 셋팅은 여기서 한다.
            // A += B ===> A = A + B
            // A |= B ===> A = A | B
            testBit |= (BIN << randNum);  //  Or은 둘중 하나라도 1이면 출력하기때문에 1 | 2^? 이 되어 2^?가 testBit에 값이 대입된다
        }
        System.out.println("testBit의 최종값은 1023이다. 진짜 ? " + testBit);  // 반복문에서 빠져나와 2^9~2^0까지의 수를 더한다

    }
}
