// 같은 문양의 숫자가 연속되게 3개 나오는 경우(예 9 8 7) > 서로 다른 문양의 같은 숫자
// 서로 다른 문양의 같은 숫자                         > 서로 다른 문양의 숫자가 연속되게 3개 나옴
// 서로 다른 문양의 숫자가 연속되게 3개 나옴            > 서로 같은 문양이 3개 나옴
// 무기간 상성이 존재한다고 가정한다(가위 바위 보처럼)
// 만약 서로 같은 문양의 숫자가 연속되게 나오는 케이스에서
// 창 987과 검 987 활 987 경우가 우연치않게 나왔다면 아래 상성을 따른다.
// 창 > 검
// 검 > 활
// 활 > 창
// 또한 창 987 vs 창 654는 큰 숫자로 구성된 쪽이 이겨야한다.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 컴퓨터와 사용자가 있음
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
                // 중복되는 숫자를 체킹하는 코드가 필요합니다:
                // 56번에서는 중복체킹하는것을 추가로 처리하여
                // 57번 문제를 풀어보도록 합시다!
                sculptureIdx = (int) (Math.random() * 3);
                randNum = (int) (Math.random() * 10);
            } while (checkDuplicate(sculptureIdx, randNum, dupNumArrCheck));

            sculpture = pattern[sculptureIdx];

            // 머리속으로만 풀려고 하면 안풀립니다.
            // 그럴땐 배열의 그림을 그려서 값이 어떻게 바뀌는지 보면 좋습니다.

            //  [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
            // -----------------------------------------
            // | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |    [0]
            // -----------------------------------------
            // | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |    [1]
            // -----------------------------------------
            // | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |    [2]
            // -----------------------------------------
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
        // 1. 문양도 일치해야하고
        // 2. 숫자가 연속되어야함
        if (!checkTripplePattern(arr, identity)) {
            return false;
        }

        // 규칙이 꼬였기 때문에 연속된 숫자 검사하는 루틴이 필요함
        if (!checkTrippleHarmonic(arr, identity)) {
            return false;
        }

        return true;
    }

    /* 아래 두 가지를 완성하면 자동으로 checkTrippleWeapon()은 완성이됩니다. */
    private Boolean checkTrippleNumber (int[][] arr, int identity) {
        return false;
    }

    private void printArr (int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    private void insertionSort (int[] num, int[] pattern, int len) {
        int i, j, valueKey, patternKey;

        System.out.println("length = " + len);

        for (i = 1; i < len; i++) {
            valueKey = num[i];
            patternKey = pattern[i];

            System.out.println("i = " + i);

            for (j = i - 1; (j != -1) && (num[j] > valueKey); j--) {
                num[j + 1] = num[j];
                pattern[j + 1] = pattern[j];

                System.out.println("j = " + j);
            }

            num[j + 1] = valueKey;
            pattern[j + 1] = patternKey;
        }
    }

    private Boolean checkHarmonic (Map<Integer, Map<Integer, Integer>> map, int identity) {

        int[] checkContinuousNumArr = new int[DISTRIBUTED_CARD_NUM];
        int[] checkPatternArr = new int[DISTRIBUTED_CARD_NUM];

        int patternCnt = 0;
        int cardCnt = 0;

        /* 키를 기준으로 정렬하기 */
        // Object[] mapKey = map.keySet().toArray();
        //Arrays.sort(mapKey);

        // 출력 데이터 형식
        // {0= {5=0}, 1= {5=1}, 2= {7=2}, 3= {4=2} }
        // {순서 = {나온숫자 = 패턴인덱스}}

        // 1. 같은 숫자가 발견되면 다음 두 개에서 연속된 숫자가 나타나야함
        //    이를 기반으로 맵 엔트리를 추출함
        //    ex) {0={5=0}, 1={5=2}, 2={6=1}, 3={7=2}}
        //    위 케이스의 경우 추출된 값은 아래와 같게 만든다.
        //    0={5=0}, 2={6=1}, 3={7=2}}
        //    결국 밸류의 키값을 체크해야 한다.
        // 2. 추출한 숫자가 패턴의 Harmonic을 구성해야함
        //    위 패턴에서 밸류의 밸류값이 0, 1, 2인지 체크한다.

        // * 키 포인트
        // Map의 경우엔 키가 중복될 수 없다라는 불변의 진리를 가짐
        for (Map.Entry<Integer, Map<Integer, Integer>> outerEntry : map.entrySet()) {
            Integer outerKey = outerEntry.getKey();
            Map<Integer, Integer> outerValue = outerEntry.getValue();

            System.out.println("Double Map Foreach OuterKey: " + outerKey);
            System.out.println("Double Map Foreach OuterValue: " + outerValue);

            for (Map.Entry<Integer, Integer> innerEntry : outerValue.entrySet()){
                checkContinuousNumArr[cardCnt++] = innerEntry.getKey();
                checkPatternArr[patternCnt++] = innerEntry.getValue();
            }
        }

        printArr(checkContinuousNumArr, DISTRIBUTED_CARD_NUM);
        printArr(checkPatternArr, DISTRIBUTED_CARD_NUM);

        insertionSort(checkContinuousNumArr, checkPatternArr, DISTRIBUTED_CARD_NUM);

        System.out.println("After Insertion Sort(삽입 정렬)");

        printArr(checkContinuousNumArr, DISTRIBUTED_CARD_NUM);
        printArr(checkPatternArr, DISTRIBUTED_CARD_NUM);

        int contCnt = 0;

        // 3 4 5 7
        // 4 6 7 8
        // 3 5 7 9
        // 3 4 8 9
        int[] firstCheckArr = new int[PATTERN_MAX];
        int[] secondCheckArr = new int[PATTERN_MAX];

        for (int i = 0; i < PATTERN_MAX; i++) {
            firstCheckArr[i] = checkContinuousNumArr[i];
            secondCheckArr[i] = checkContinuousNumArr[i + 1];
        }

        int first = firstCheckArr[0];
        int second = secondCheckArr[0];

        Boolean isFirst = false, isSecond = false;

        if ((firstCheckArr[1] == (first + 1)) && (firstCheckArr[2] == (first + 2))) {
            System.out.println("시작위치에서 연속된 숫자가 나타납니다.");
            isFirst = true;
        }

        if ((secondCheckArr[1] == (second + 1)) && (secondCheckArr[2] == (second + 2))) {
            System.out.println("두번째 위치에서 연속된 숫자가 나타납니다.");
            isSecond = true;
        }

        if (!isFirst && !isSecond) {
            return false;
        }

        // 여기까지 연속된 숫자를 잡아냈음
        // 어차피 연속된 위치와 패턴은 같은 자리에 있으므로 검사해야하는 위치는
        // if문이 어디서 시작되었는지의 여부로 결정됨
        // Harmonic 패턴 검사
        Boolean isHarmonic = false;

        int[] harmonicCheckArr = new int[PATTERN_MAX];

        for (int i = 0; i < PATTERN_MAX; i++) {
            harmonicCheckArr[checkPatternArr[i]]++;
        }

        if (harmonicCheckArr[0] != 0 && harmonicCheckArr[1] != 0 && harmonicCheckArr[2] != 0) {
            return true;
        }

        // 각각의 밸류값과 키값을 뽑아낸 상태에서 생각해야할 부분
        // 1. 키   - 6  3  2  3
        //    밸류 - 0  1  1  2
        // 정렬 이후
        //    키   - 2  3  3  6
        //    밸류 - 0  1  1  2
        // 위와 같은 문제를 어떻게 해결해야하는지에 대한 고민이 필요함
        // 실제 배열의 크기가 작으므로 Insertion Sort를 활용하기에 아주 좋음
        // 만약 배열의 크기가 크다면 Quick Sort 혹은 Radix Sort를 사용하는 것이 좋음


        //System.out.println("Harmonic 검사: " + map);


        /*
        for (int i = 0; i < PATTERN_MAX; i++) {
            if (checkPatternArr[i] > 0) {
                patternCnt++;
            }
        }
        if (patternCnt == 3) {
            return true;
        }
         */

        return false;
    }
    /* 서로 다른 문양의 숫자가 연속되게 3개 나옴 */
    private Boolean checkTrippleHarmonic (int[][] arr, int identity) {
        // 1. 먼저 제각기 다른 문양들이 배치되어 있는지 검사한다.
        //    제각기 다른 문양이 아닌 경우에도 즉결 처분(false)
        // 2. 서로 연속된 숫자가 아니라면 바로 false 처리

        // 두개를 모두 만족하는 경우에만 true
        // ------------------ 모든 패턴이 조합되는 케이스 시작 ------------------
        /*
        int[] checkContinuousNumArr = new int[DISTRIBUTED_CARD_NUM];
        int[] checkPatternArr = new int[PATTERN_MAX];
        Boolean isHarmonicPattern = false;
        int patternCnt = 0;
        int cardCnt = 0;
        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                // 같은 패턴인 경우는 훨씬 쉬웠지만
                // 서로 다른 패턴을 찾아야 하는 경우는
                // 각각의 패턴을 채웠는지 여부를 체크해야할 것이다.
                if (arr[i][j] != -1) {
                    checkPatternArr[i]++;
                    checkContinuousNumArr[cardCnt++] = arr[i][j];
                }
            }
            System.out.printf("checkPatternArr[%d] = %d\n", i, checkPatternArr[i]);
        }
        for (int i = 0; i < DISTRIBUTED_CARD_NUM; i++) {
            System.out.printf("checkContinuousNumArr[%d] = %d\n", i, checkContinuousNumArr[i]);
        }
        for (int i = 0; i < PATTERN_MAX; i++) {
            if (checkPatternArr[i] > 0) {
                patternCnt++;
            }
        }
        if (patternCnt == 3) {
            isHarmonicPattern = true;
        } else {
            return false;
        }
        System.out.println("isHarmonicPattern = " + isHarmonicPattern);
         */
        // ------------------ 모든 패턴이 조합되는 케이스 끝 ------------------

        // ------------------ 서로 연속된 숫자 처리 시작 ------------------
        /*
        checkPatternArr[0] = 2 - 창
        checkPatternArr[1] = 1 - 검
        checkPatternArr[2] = 1 - 활     1  2
        checkContinuousNumArr[0] = 7 - 활 창
        checkContinuousNumArr[1] = 2 - 검 활
        checkContinuousNumArr[2] = 0 - 창 검
        checkContinuousNumArr[3] = 1 - 창 창
                                (나온값, 패턴인덱스)
        1) HashMap(키, 값) ===> (7, 2), (2, 1), (0, 0), (1, 0)
        2)                ===> (7, 0), (2, 2), (0, 1), (1, 0)
                               이와 같은 구성시 문양이 다른것과 관계 없이
                               같은 숫자가 배치되면 마지막 혹은 큰 값이 덮어써지게 되는 문제가 발생함
        checkPatternArr[0] = 2
        checkPatternArr[1] = 1
        checkPatternArr[2] = 1         1
        checkContinuousNumArr[0] = 9 - 창
        checkContinuousNumArr[1] = 1 - 검
        checkContinuousNumArr[2] = 7 - 검
        checkContinuousNumArr[3] = 9 - 활
        1) HashMap(키, 값) ===> (9, 0), (1, 1), (7, 1), (9, 2)
                          ===> (9, 2), (1, 1), (7, 1) <<<==== 이 부분이 문제가 되고 있음
                          만약 문양을 키값으로 잡는다고 하더라도 같은 문제가 반복될 것이다.
                          그러므로 맵을 이중으로 사용해서 문제를 회피하도록 한다.
        sol) 솔루션 ===> HashMap(키, (키, 밸류))
             (0, (9, 0)), (1, (1, 1)), (2, (7, 1)), (3, (9, 2))
         */
        Map<Integer, Map<Integer, Integer>> orderMap =
                new HashMap<Integer, Map<Integer, Integer>>();
        Map<Integer, Integer> cardsMap[] = new HashMap[DISTRIBUTED_CARD_NUM];

        for (int i = 0; i < DISTRIBUTED_CARD_NUM; i++) {
            cardsMap[i] = new HashMap<Integer, Integer>();
        }

        int orderCnt = 0;
        int cardsCnt = 0;

        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                if (arr[i][j] != -1) {
                    cardsMap[cardsCnt].put(arr[i][j], i);
                    orderMap.put(orderCnt++, cardsMap[cardsCnt++]);

                    // 일단 이 시점에서 위의 맵 데이터들은 완성이 됨
                    // 다음으로 해야할 일은 무엇인지 기록해보자면
                    // 1. 키값들(실제 숫자)을 확인해야함
                    // 2. 밸류값들(패턴 문양 인덱스)를 확인해야함
                }
            }
        }

        if (checkHarmonic(orderMap, identity)) {
            return true;
        }

        /*
        cardCnt = 0;
        for (Map.Entry<Integer, Integer> cardEntry : cardsMap.entrySet()) {
            Integer key = cardEntry.getKey();
            Integer value = cardEntry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
         */

        //System.out.println(cardsMap);
        // ------------------ 서로 연속된 숫자 처리 끝 ------------------

        return false;
    }
    private Boolean checkTripplePattern (int[][] arr, int identity) {
        // 1. 전체를 순회하며 처음 나오는 값을 찾는다.
        // 2. 처음 나오는 값의 숫자와 패턴을 파악한다.
        // 3. 같은 패턴이 3개 존재하는지 검사한다.

        // 4. 만약 조건이 달성되지 않는다면 다시 2번째 값으로 위 작업을 반복한다.
        // 5. 2번째 값에서 판정이 되지 않았다면 다음을 검사할 필요가 없다!

        // ex) 창, 검, 활, 검
        // ex) 창, 검, 검, 검
        // ex) 활, 창, 활, 활
        // ex) 활, 창, 검, 활
        // ex) 창, 활, 창, 창
        int[] savedRow = new int[DISTRIBUTED_CARD_NUM];
        int rowCnt = 0;

        int[] savedCol = new int[DISTRIBUTED_CARD_NUM];
        int colCnt = 0;

        if (identity == USER) {
            System.out.println("사용자 데이터입니다.");
        } else if (identity == COMPUTER) {
            System.out.println("컴퓨터 데이터입니다.");
        }

        // 가만 보니 숫자 0이 들어가서 0 과 0이 같아서 구별이 안되는 문제도 있고
        // 조건이 0 보다 큰 것으로 잡아놨는데 0이니까 식별 자체를 안하는 문제가 겹쳤었음

        //  [0]  [1]  [2]  [3]
        // --------------------
        // | 0 | -1 | -1 | -1 |   [0] spear
        // --------------------
        // | -1 | 5 | -1 | -1 |   [1] sword
        // --------------------
        // | 2 | -1 | -1 | 1  |   [2] arrow
        // --------------------

        // savedRow | 0 | 1 | 2 | 2 |
        // savedCol | 7 | 7 | 0 | 3 |

        for (int i = 0; i < PATTERN_MAX; i++) {
            for (int j = 0; j < DISTRIBUTED_CARD_NUM; j++) {
                // 주의해야할 것이 arr에 1, 0으로 값이 있다 없다가 아니라
                // 실제 셋팅된 값 자체가 배치되어 있다!
                // 그러므로 실제 사용하는 숫자 0이 들어간 경우 문제가 발생할 수 있음
                if (arr[i][j] != -1) {
                    savedRow[rowCnt++] = i;
                    savedCol[colCnt++] = j;
                }
            }
        }

        int patternCnt = 0;
        int secondaryPatternCnt = 0;

        // savedRow | 0 | 1 | 2 | 2 |
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
        // 현재 케이스에서 바로 일반화를 적용하기는 어려움
        // 그러므로 각각의 패턴들에 대한 검사를 항목별로 만들어준다.
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
    }
}
