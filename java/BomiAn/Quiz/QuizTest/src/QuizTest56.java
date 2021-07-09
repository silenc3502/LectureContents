// 강사님이 만들어주신 코드를 보며 HashMap or HashSet 을 이용해서 완성하고 싶었으나
// 코드에 대한 의도 파악이 잘 안되었습니다. 아마도 오늘 설명을 한번 더 들으며 이해해야 할 것 같습니다.
// 만약 저렇게 하면 값을 랜덤으로 뿌릴 수는 있어도 어떻게 값을 판별하지???(승부를 어떻게 가리지)
// 좋은 아이디어가 안나서 그냥 할 수 있는 방법들로 만들어 봤습니다.
// 근데 중복제거에서 문제가 생긴 것 같은데 아무리 바꿔봐도 문제가 있어 봐주시면 좋을 것 같습니다.
// (중복이 나오면 오류가 뜸)
// 또 메소드 cntScores 로 comScore userScore 인자를 받아서 점수를 넣어주려고 했는데 안되고 0으로만 나오는데 왜그러는 걸까요?


// 1. arraylist 를 문양 / 수 2개를 만들어서 이용할 것
// 2. 사용자와 컴퓨터의 arrayList 도 만들어 주자. (4개의 카드를 받을)
//    1) 하려고 했으나 따로 따로 만들 필요 없이 하나로 같이 써보자
// 3. for 문을 이용해서 두 리스트에서 값을 랜덤으로 받아 게임 플레이어들에게 값을 넣어줌
//   1) 랜덤으로 뽑을때 중복을 제거하는 메소드도 필요
// 4. if 를 통해 승부를 판별하는 조건을 넣어줌
//   1) 점수를 올려서 차등을 줄 수 있도록
// -- 같은 문양의 숫자가 연속되게 3개 나오는 경우(예 9 8 7) == 10점
// -- 서로 다른 문양의 같은 숫자 == 8점
// -- 서로 다른 문양의 숫자가 연속되게 3개 나옴 == 5점
// -- 서로 같은 문양이 3개 나옴  == 3점
// -- 이것도 저것도 아니면 1점
// 마지막으로 승부의 결과를 프린트

import java.util.ArrayList;
import java.util.Arrays;

class CardGame {
    ArrayList<String> patternList;
    ArrayList<Integer> numberList;
    ArrayList<String> randPattern;
    ArrayList<Integer> randNumber;
    Boolean isTrue;
    int comScore;
    int userScore;

    public CardGame () {
    String[] pattern = {"spear", "sword", "arrow"};
    Integer[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    patternList = new ArrayList<String>(Arrays.asList(pattern));
    numberList = new ArrayList<Integer>(Arrays.asList(number));

    randPattern = new ArrayList<String>();
    randNumber = new ArrayList<Integer>();


    isTrue = false;



    }

    public void gameStart () {
        comPlayer();
        userPlayer();
        whoWin();

    }

    private void mixCard () {

        do {


            for (int i = 0; i < 4; i++) {
                randPattern.add(patternList.get((int) (Math.random() * 3)));
                randNumber.add(numberList.get((int) (Math.random() * 10)));

            }

            randNonDuplicate();


        }while (isTrue);

        System.out.println(randPattern);
        System.out.println(randNumber);

    }

    private void randNonDuplicate () {

        for (int i = 0; i < 3; i++) {
            String patternA = randPattern.get(i);
            int numberA = randNumber.get(i);


            for (int j = i + 1 ; j < 4; j++) {
                String patternB = randPattern.get(j);
                int numberB = randNumber.get(j);

                if (patternA.equals(patternB) && numberA == numberB) {
                    randPattern.clear();
                    randNumber.clear();
                    isTrue = true;

                } else {
                    isTrue = false;
                }
            }
        }

    }

    public void cntScore (int scores){

        for (int i = 0;i < 2; i++) {
            int num = randNumber.get(i);
            String value = randPattern.get(i);
            if (randPattern.get(i + 1).equals(value) && randPattern.get(i + 2).equals(value) && randNumber.get(i + 1) == num + 1 && randNumber.get(i + 2) == num + 2) {
                scores = 10;
            } else if (!randPattern.get(i + 1).equals(value) && !randPattern.get(i + 2).equals(value) && !randPattern.get(i + 1).equals(randPattern.get(i + 2)) && randNumber.get(i + 1) == num && randNumber.get(i + 2) == num ) {
                scores = 8;
            } else if (!randPattern.get(i + 1).equals(value) && !randPattern.get(i + 2).equals(value) && !randPattern.get(i + 1).equals(randPattern.get(i + 2)) && randNumber.get(i + 1) == num + 1 && randNumber.get(i + 2) == num + 2) {
                scores  = 5;
            } else if (randPattern.get(i + 1).equals(value) && randPattern.get(i + 2).equals(value)){
                scores = 3;
            } else {
                scores = 1;
            }

        }
        System.out.println(scores);

    }

    private void comPlayer () {
        System.out.println(" 컴퓨터에게 카드를 분배합니다. ");
        mixCard();
        cntScore(comScore);
        System.out.println(comScore);
    }

    private void userPlayer () {
        randPattern.clear();
        randNumber.clear();
        System.out.println(" 사용자에게 카드를 분배합니다. ");
        mixCard();
        cntScore(userScore);
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








public class QuizTest56 {
    public static void main(String[] args) {
        CardGame cg = new CardGame();

        cg.gameStart();

    }
}
