

import java.util.HashMap;
import java.util.Map;


class ThreePoker {
    final int PATTERN_MAX = 3;
    final int CARD_MAX = 10;
    final int DISTRIBUTED_CARD_NUM = 4;

    final int USER = 1024;
    final int COMPUTER = 2048;

    private Map<String, Map<String, Integer>> map;
    private Map<String, Integer>[] preparedMap;
    private String[] pattern = {"spear", "sword", "arrow"};

    private int[][] dupNumArrCheck;

    private int[][] usrCard;
    private int[][] comCard;

    public ThreePoker () {
        map = new HashMap<String, Map<String, Integer>>();
        preparedMap = new HashMap[PATTERN_MAX];

        dupNumArrCheck = new int[PATTERN_MAX][CARD_MAX];

        usrCard = new int[PATTERN_MAX][DISTRIBUTED_CARD_NUM];
        comCard = new int[PATTERN_MAX][DISTRIBUTED_CARD_NUM];

        for (int i = 0; i < PATTERN_MAX; i++) {
            preparedMap[i] = new HashMap<String, Integer>();

            for (int j = 0; j < CARD_MAX; j++) {
                preparedMap[i].put(pattern[i] + j, j);
            }

            for (int k = 0; k < DISTRIBUTED_CARD_NUM; k++) {
                usrCard[i][k] = -1;
                comCard[i][k] = -1;
            }
        }

        for (int i = 0; i < PATTERN_MAX; i++) {
            map.put(pattern[i], preparedMap[i]);
        }
    }

    public void printMap () {
        System.out.println(map);
    }

    public static Boolean checkDuplicate (
            int patternIdx, int randNum, int[][] randCheckArr) {

        if (randCheckArr[patternIdx][randNum] > 0) {
            return true;
        }

        return false;
    }

    public void distributeCard (int[][] arr, int identity) {
        String sculpture;
        int sculptureIdx;
        int randNum;

        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            do {

                sculptureIdx = (int) (Math.random() * 3);
                randNum = (int) (Math.random() * 10);
            } while (checkDuplicate(sculptureIdx, randNum, dupNumArrCheck));

            sculpture = pattern[sculptureIdx];

            dupNumArrCheck[sculptureIdx][randNum]++;
            arr[sculptureIdx][cnt++] = randNum;

            if (identity == USER) {
                System.out.print("사용자");
            } else if (identity == COMPUTER) {
                System.out.print("컴퓨터");
            }

            System.out.println("에게 분배된 카드는 = " + sculpture +
                    " 문양의 " + randNum + " 카드입니다!");
        }
    }



    private Boolean checkTrippleWeapon (int[][] arr, int identity) {

        if (!checkTripplePattern(arr, identity)) {
            return false;
        }


        if (!checkTrippleHarmonic(arr, identity)) {
            return false;
        }

        return true;
    }


    private Boolean checkTrippleNumber (int[][] arr, int identity) {


        return false;
    }
    private Boolean checkTrippleHarmonic (int[][] arr, int identity) {
        return false;
    }
    private Boolean checkTripplePattern (int[][] arr, int identity) {

        int[] savedRow = new int[DISTRIBUTED_CARD_NUM];
        int rowCnt = 0;

        int[] savedCol = new int[DISTRIBUTED_CARD_NUM];
        int colCnt = 0;

        if (identity == USER) {
            System.out.println("사용자 데이터입니다.");
        } else if (identity == COMPUTER) {
            System.out.println("컴퓨터 데이터입니다.");
        }



        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {

                if (arr[i][j] != -1) {
                    savedRow[rowCnt++] = i;
                    savedCol[colCnt++] = j;
                }
            }
        }

        int patternCnt = 0;
        int secondaryPatternCnt = 0;


        for (int i = 0; i < DISTRIBUTED_CARD_NUM; i++) {
            if (savedRow[0] == savedRow[i]) {
                patternCnt++;
            }
            if (savedRow[1] == savedRow[i]) {
                secondaryPatternCnt++;
            }
        }

        System.out.println(pattern[savedRow[0]]);
        System.out.println("첫 번째 패턴과 일치하는 개수 = " + patternCnt);
        System.out.println(pattern[savedRow[1]]);
        System.out.println("두 번째 패턴과 일치하는 개수 = " + secondaryPatternCnt);

        if (patternCnt >= 3 || secondaryPatternCnt >= 3) {
            System.out.println("동일한 패턴 3개 이상 검출되었습니다!");
            return true;
        }

        return false;
    }

    private String checkPattern (int[][] arr, int identity) {

        if (checkTrippleWeapon(arr, identity)) {
            return "TrippleWeapon";
        } else if (checkTrippleNumber(arr, identity)) {
            return "TrippleNumber";
        } else if (checkTrippleHarmonic(arr, identity)) {
            return "TrippleHarmonic";
        } else if (checkTripplePattern(arr, identity)) {
            return "TripplePattern";
        } else {
            return "Bang";
        }
    }

    // 먼저 승리 패턴에 대한 분석이 필요함
    // 1. 같은 문양의 연속된 숫자 3개       - 트리플 웨폰(TrippleWeapon)
    // 2. 서로 다른 문양의 같은 숫자        - 트리플 넘버(TrippleNumber)
    // 3. 서로 다른 문양 + 연속된 숫자 3개  - 트리플 하모닉(TrippleHarmonic)
    // 4. 서로 같은 문양                  - 트리플 패턴(TripplePattern)
    // 5. 아무것도 아님                   - 꽝(Bang)
    public void checkWinner () {
        // 1. String 값으로 각각의 패를 가져오도록 한다.
        String usr = checkPattern(usrCard, USER);
        String com = checkPattern(comCard, COMPUTER);

        System.out.println("사용자 패 검사: " + usr);
        System.out.println("컴퓨터 패 검사: " + com);
    }

    public void playGame () {
        Boolean wantContinue = false;

        do {
            distributeCard(usrCard, USER);
            System.out.println("------------------절취선------------------");
            distributeCard(comCard, COMPUTER);
            printArr(usrCard, USER);
            System.out.println("------------------절취선------------------");
            printArr(comCard, COMPUTER);
            checkWinner();
        } while (wantContinue);
    }

    public void printArr (int[][] distArr, int identity) {
        if (identity == USER) {
            System.out.println("사용자");
        } else if (identity == COMPUTER) {
            System.out.println("컴퓨터");
        }

        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                System.out.printf("distArr[%d][%d] = %3d ", i, j, distArr[i][j]);
            }
            System.out.println();
        }
    }
}

public class Prob57 {
    public static void main(String[] args) {
        ThreePoker tp = new ThreePoker();

        tp.playGame();

        // 여러분들이 알고 있는 수학의 그 파이가 맞습니다.
        System.out.println("원주율 PI = " + Math.PI);
    }
}