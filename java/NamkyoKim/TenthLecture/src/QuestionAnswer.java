class AverageTest {
    int[] scores;
    int len;
    float mean;

    public AverageTest (int scoreArr[]) {
        len = scoreArr.length;

        scores = new int[len];

        for (int i = 0; i < len; i++) {
            scores[i] = scoreArr[i];
        }
    }
    // 각각의 평균들이 들어오는 경우는 생성자에서 즉시 결과값을 만들어도 됨
    public AverageTest (AverageTest A, AverageTest B,
                        AverageTest C, AverageTest D, AverageTest E) {
        float sum = 0;

        for (int i = 0; i < A.getLength(); i++) {
            sum += A.getScores()[i];
            sum += B.getScores()[i];
            sum += C.getScores()[i];
            sum += D.getScores()[i];
            sum += E.getScores()[i];
        }

        mean = sum / 25.f;
        //mean = (A.getMean() + B.getMean() + C.getMean() + D.getMean() + E.getMean()) / (float)A.getLength();
    }

    // 매서드의 목적은 결국 재활용을 하기 위함입니다.
    // 그러나 현재 케이스에서 이 매서드를 만든 의미가 사라져버림
    // 이와 같은 현상을 원천 봉쇄하기 위해
    // 기능을 최소한으로 쪼개서 가장 작은 단위로 매서드를 만드는 겁니다.
    public float getNonRecycleAverage () {
        float sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        return sum / (float)scores.length;
    }

    // 재활용이 가능하도록 가장 작은 단위로 구현한 경우
    public void calcMean () {
        float sum = 0;

        for (int i = 0; i < len; i++) {
            sum += scores[i];
        }

        mean = sum / (float)len;
    }

    public int[] getScores() {
        return scores;
    }
    public float getMean() {
        return mean;
    }
    public int getLength() { return len; }
}

// 잠시 보류함(배열 클래스를 아직 배우지 않아서 애매한 상황입니다 ㅠ)
public class QuestionAnswer {
    public static void main(String[] args) {
        // 역할과 책임(이 매서드는 이것을 수행한다는 - 역할이 명확해야하고
        // 안전하게 작업이 진행된다는 책임이 분명해야함(데이터 무결성을 의미함)

        // A반, B반, C반, D반, E반이 있습니다.
        // 5개 반의 평균을 각각 구하고
        // A, B, C, D, E 반을 모두 합한 전교에서의 평균을 구해봅시다.

        // ex) calc 매서드와 get 매서드를 분리하지 않은 경우
        //                    vs
        //       calc 매서드와 get 매서드를 분리한 경우
        int[] A = { 10, 20, 30, 40, 50 };
        int[] B = { 10, 20, 30, 40, 50 };
        int[] C = { 10, 20, 30, 40, 50 };
        int[] D = { 10, 20, 30, 40, 50 };
        int[] E = { 10, 20, 30, 40, 50 };

        AverageTest atA = new AverageTest(A);
        AverageTest atB = new AverageTest(B);
        AverageTest atC = new AverageTest(C);
        AverageTest atD = new AverageTest(D);
        AverageTest atE = new AverageTest(E);

        System.out.println("A반 평균 = " + atA.getNonRecycleAverage());
        System.out.println("B반 평균 = " + atB.getNonRecycleAverage());
        System.out.println("C반 평균 = " + atC.getNonRecycleAverage());
        System.out.println("D반 평균 = " + atD.getNonRecycleAverage());
        System.out.println("E반 평균 = " + atE.getNonRecycleAverage());

        // 전교생의 평균은 이제 ?????
        // 매서드를 새로 만들어야 하네요 ?
        // + 배열 입력도 새로 받아야 하는군요 ?
        AverageTest allClass2 = new AverageTest(atA, atB, atC, atD, atE);

        System.out.println("전체 평균 = " + allClass2.getMean());

        // 재활용 코드
        AverageTest atA2 = new AverageTest(A);
        AverageTest atB2 = new AverageTest(B);
        AverageTest atC2 = new AverageTest(C);
        AverageTest atD2 = new AverageTest(D);
        AverageTest atE2 = new AverageTest(E);

        atA2.calcMean();
        atB2.calcMean();
        atC2.calcMean();
        atD2.calcMean();
        atE2.calcMean();

        System.out.println("A반 평균 = " + atA2.getMean());
        System.out.println("B반 평균 = " + atB2.getMean());
        System.out.println("C반 평균 = " + atC2.getMean());
        System.out.println("D반 평균 = " + atD2.getMean());
        System.out.println("E반 평균 = " + atE2.getMean());

        // 전교 평균 케이스
        AverageTest allClass = new AverageTest(atA2, atB2, atC2, atD2, atE2);

        // Getter는 특정 클래스 객체 내부의 값을 외부로 송출해주는 역할을 합니다.
        // 송출이 되는 이유는 return을 하기 때문입니다.
        // return test 라고 한다면 test라는 변수의 값을 함수에서 송출하겠다는 의미!
        System.out.println("전체 평균 = " + allClass.getMean());
    }
}
