import java.util.ArrayList;
import java.util.Arrays;

class CardGame2 {
    ArrayList<String> patternList;
    ArrayList<Integer> numberList;
    ArrayList<String> randPattern;
    ArrayList<Integer> randNumber;
    Boolean isTrue;
    int comScore;
    int userScore;

    Boolean needInitialization;

    public CardGame2 () {
        String[] pattern = {"spear", "sword", "arrow"};
        Integer[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        patternList = new ArrayList<String>(Arrays.asList(pattern));
        numberList = new ArrayList<Integer>(Arrays.asList(number));

        randPattern = new ArrayList<String>();
        randNumber = new ArrayList<Integer>();

        isTrue = false;
        needInitialization = false;
    }

    public void gameStart () {
        comPlayer();
        userPlayer();
        whoWin();
    }

    // (중복이 나오면 오류가 뜸)
    private void mixCard () {
        do {
            for (int i = 0; i < 4; i++) {
                int tmp1 = (int) (Math.random() * 3);
                randPattern.add(patternList.get(tmp1));

                int tmp2 = (int) (Math.random() * 10);
                randNumber.add(numberList.get(tmp2));

                System.out.printf("%d번째 루프 = %s, %d\n",
                        i, patternList.get(tmp1), numberList.get(tmp2));
            }
            randNonDuplicate();

            if (needInitialization) {
                randPattern.clear();
                randNumber.clear();
                needInitialization = false;
            }
        } while (isTrue);
        // 에러메시지를 살펴보면
        // 아래와 같다.
        // []
        // []
        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        // 즉 isTrue가 false가 나오면 안되는 상황임에도 불구하고
        // 다중 루프에서 반복 처리를 하다보니 잘못된 상황이 도출되어버림
        // 결국 마지막에 spear 9와, sword 6으로 인해 isTrue는 false가 되어 중복임에도 불구하고
        // 아래쪽으로 내려가서 아무것도 없는 공백 배열을 출력하고
        // clear어 된 상태에서 ArrayList를 다루니 Index: 0, Size: 0이 나오는 상황이 도출됨

        System.out.println(randPattern);
        System.out.println(randNumber);
    }

    private void randNonDuplicate () {

        // 아래 이중 포문 로직에 문제가 있음을 확인할 수 있음
        for (int i = 0; i < 3; i++) {
            String patternA = randPattern.get(i);
            int numberA = randNumber.get(i);

            System.out.printf("%d(i) 번째: %s, %d\n",
                    i, randPattern.get(i), randNumber.get(i));

            if (needInitialization) {
                break;
            }

            for (int j = i + 1 ; j < 4; j++) {
                // 여기까지 검사를 했다면
                // 결론적으로 randPattern에 값을 설정하는 부분에 문제가 있어
                // get(3)에서 문제가 발생했음을 유추할 수 있음
                // 그러므로 randPattern 값을 설정하는 부분을 확인해야함
                String patternB = randPattern.get(j);
                int numberB = randNumber.get(j);

                System.out.printf("%d(j) 번째: %s, %d\n",
                        j, randPattern.get(j), randNumber.get(j));

                if (patternA.equals(patternB) && numberA == numberB) {
                    System.out.println("마설 다 지우나요 ?");
                    //randPattern.clear();
                    //randNumber.clear();
                    needInitialization = true;
                    isTrue = true;
                    break;
                } else {
                    isTrue = false;
                }
            }
        }
    }

    public int cntScore (){
        int tmp = 0;

        for (int i = 0;i < 2; i++) {
            int num = randNumber.get(i);
            String value = randPattern.get(i);

            if (randPattern.get(i + 1).equals(value) &&
                    randPattern.get(i + 2).equals(value) &&
                    randNumber.get(i + 1) == num + 1 &&
                    randNumber.get(i + 2) == num + 2) {
                tmp = 10;
            } else if (!randPattern.get(i + 1).equals(value) &&
                    !randPattern.get(i + 2).equals(value) &&
                    !randPattern.get(i + 1).equals(randPattern.get(i + 2)) &&
                    randNumber.get(i + 1) == num &&
                    randNumber.get(i + 2) == num ) {
                tmp = 8;
            } else if (!randPattern.get(i + 1).equals(value) &&
                    !randPattern.get(i + 2).equals(value) &&
                    !randPattern.get(i + 1).equals(randPattern.get(i + 2)) &&
                    randNumber.get(i + 1) == num + 1 &&
                    randNumber.get(i + 2) == num + 2) {
                tmp  = 5;
            } else if (randPattern.get(i + 1).equals(value) &&
                    randPattern.get(i + 2).equals(value)){
                tmp = 3;
            } else {
                tmp = 1;
            }


        }
        System.out.println(tmp);

        return tmp;
    }

    private void comPlayer () {
        System.out.println(" 컴퓨터에게 카드를 분배합니다. ");
        mixCard();
        comScore = cntScore();
        System.out.println(comScore);
    }

    private void userPlayer () {
        randPattern.clear();
        randNumber.clear();
        System.out.println(" 사용자에게 카드를 분배합니다. ");
        mixCard();
        userScore = cntScore();
        System.out.println(userScore);
    }

    private void whoWin () {
        if (comScore > userScore) {
            System.out.printf("사용자 (%d) vs 컴퓨터 (%d) 로 컴푸터가 이겼습니다. \n", userScore, comScore);
        } else if (comScore < userScore) {
            System.out.printf("사용자 (%d) vs 컴퓨터 (%d) 로 사용자가 이겼습니다. \n", userScore, comScore);
        } else {
            System.out.println("이번 판은 동점이 나왔습니다. ");
        }
    }
}

public class Quiz56ProblemSolve {
    public static void main(String[] args) {
        CardGame2 cg = new CardGame2();

        cg.gameStart();
    }
}
