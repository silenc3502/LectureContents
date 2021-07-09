//아주 특수한 카지노에 왔다.
//현재 내 수중엔 1000만원이 있다.
//카지노에서 판돈을 걸 수 있고 베팅 비율은 Scanner를 통해 입력 받을 수 있다.
//상대방이 파산하면 이기는 게임이다.
//주사위 2개를 사용하는 게임이다.
//숫자가 높은 사람이 이긴다(컴퓨터 vs 사람)
//첫 번째 주사위가 짝수가 나온 경우에만 두 번째 주사위를 굴릴 수 있다.
//두 번째 주사위는 특수 능력을 가지고 있는 주사위다.
//숫자 1이 나오면 내 주사위 값을 + 3 할 수 있다.
//숫자가 3이 나오면 상대방 주사위 값을 -2 할 수 있다.
//숫자 4가 나오면 내 주사위 값이 0이 된다.
//숫자 6이 나오면 각자 만든 주사위 값을 2배로 뻥튀기 한다.
//(2배 뻥튀기는 첫번째 주사위 + 두번째 주사위를 모두 진행한 후 적용한다)
//누가 파산하고 누가 승리를 거머쥐는지 프로그래밍해보자!

// 컴퓨터돈, 내돈 판돈 다 없어졌는지 여부 , 키보드입력, 주사위2개사용
// 첫 번째 주사위가 짝수가 아니면 두번째 주사위 사용불가
// 두번째 주사위는 특수 스킬이 존재
// 승패 판정은 두 개의 주사위 값의 합산으로 판정
import java.util.Scanner;

class DiceDeathGame {
    // 여기서 final로 선언한 변수들은 변하지 않는 상수 이므로 final로 지정  아래 매서드내부에
    // 코드들이 훨씬 깔끔해지고 다른사람이봐도 확실하게 인식할수있음
    final int MAX_PLAYER = 2; // 플레이어 컴퓨터 / 사용자 2명이므로 2 로초기화
    final int DICE_IDX = MAX_PLAYER + 1; // 다이스의 인덱스값으로 플레이어들의 값들과 합쳐진값들을 저장해야함 배열 3개를 만들어야해서
    final int START_MONEY = 1000; // 초기 시드머니 컴퓨터와 사용자 둘 다 동일하기 때문에 1000으로 고정

    final int FIRST_IDX = 0; // 첫번째 주사위값
    final int SECOND_IDX = 1; // 두번째 주사위값
    final int TOTAL_IDX = 2; // 토탈 주사위값

    final int DICE_RANGE = 6; // (MATH.RANDOM() * 6 + 1) 랜덤값 범위 설정하기위해
    final int DICE_START_OFFSET = 1; // (MATH.RANDOM() * 6 + 1) 랜덤값 범위 설정하기위해

    int comMoney;        // 컴퓨터 초기시드담을 변수 선언
    int usrMoney;       // 유저초기시드담을 변수 선언
    int betMoney;       // 베팅금액 변수 선언

    int roundNum;       // 라운드 변수 선언

    Boolean isAlive;    // 참 거짓 판별하는 Boolean 데이터 타입 필요해서 선언
    Scanner scan;       // 배팅금 입력을 위해 스캐너 선언

    int[] comDice; // com과 usr의 다이스 값을 배열로 만듬
    int[] usrDice;

    public DiceDeathGame () { // 생성자 부분
        roundNum = 0; // 라운드 체크를 하기위해 0으로 초기화했는데 생성자에 쓴이유는 생성자 부분은
                       // 초기화하는 것들만 모아놓아야 깔끔하고 책임과 역할로 딱 구분되어있음
        comDice = new int[DICE_IDX];    // comDice와 usrDice에 초기값과 두 번째 주사위값과
        usrDice = new int[DICE_IDX];    // 합을 넣기위해 인덱스3을 초기화

        isAlive = true;                 // 아래 매서드들에서 Boolen 타입이 필요하기떄문에 true로 초기화
        scan = new Scanner(System.in);  // 스캐너 초기화

        comMoney = START_MONEY;         // 초기 시드머니 초기화
        usrMoney = START_MONEY;         // 초기 시드머니 초기화
    }
    private void bettingMoney () {  // 이 구문이 시작으로 매 라운드 표시와 돈을 입력하는 구문 출력 후 betMoney에 대입
        System.out.printf("현재 %d 라운드입니다.\n", ++roundNum);
        System.out.printf("이게임을 시작한 당신 오늘 둘중 하나는 인생 로그아웃합니다.\n" +
                "돈이 부족하면 손모가지나 장기로 대체 가능합니다.\n" +
                "판돈을 입력하시오: ");
        betMoney = scan.nextInt();
    }
    public void gameStart () { // 여기 매소드가 중재자 역할로  do~while을 사용해서 매서드들을 실행한다
        do {
            // 여기 do~ while부분이 왜 이 매서드 순서대로 실행 되어야 하는건지 궁금했는데 매서드 하나하나 기능적으로 읽어보고
            // 주석을 달면서 보니까 강사님이 풀이하신대로 실행해야 정상적인 구현이 된다는걸 알게됨 ! 뭐라고 설명을 못하지만
            // 이렇게 해야 매끄럽게 실행되는거같음
            bettingMoney(); // 아래에 메인에서 호출을 해서 이부분부터 do~while 이므로 무조건 한번 실행
            runDice();
            checkMagicDiceSkill();
            whoGetBetMoney();
            canWePlay();
            checkEachMoney();
        } while (isAlive); // isAlive는 트루로 계속 실행되게 하고 canWePlay이 매서드
                            // 안에서 한쪽이라도 돈이 떨어진면 루프 끝
    }
    private void checkEachMoney () { // 중간중간 금액 체크를 하기 위해 만든 매서드
        System.out.printf("사용자 수중 금전: %d, 컴퓨터 수중 금전: %d\n", usrMoney, comMoney);
    }
    private void canWePlay () { // 돈이 0원이 되면 끝나는 매서드
        if (usrMoney <= 0 || comMoney <= 0) { // ex) usrMoney가 0보다 작거나 같아지면 참이 되고 || 연산이기 때문에
                                            // 하나라도 참이되면 조건 성립 그래서 isAlive =  false
            isAlive = false;
        }
    }
    private void whoGetBetMoney () { // 주사위 값을 비교하는 매서드부분
        int usrTotDice = usrDice[TOTAL_IDX]; // TOTAL_IDX 부분에 토탈값이 담겨있고
        int comTotDice = comDice[TOTAL_IDX]; // 깔끔하게 하기위해서 변수에 담고 초기화
                                            // 깔끔하게 하기위해서인지 배열에서 꺼내서 확인하려고한건지 !* 의문 *!
        if (usrTotDice > comTotDice) {
            System.out.printf("이번판은 사용자가 이겼습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
            usrMoney += betMoney; // 사용자가 이겼으므로 사용자 돈은 + 컴퓨터돈은 - 로 처리 아래도 동일
            comMoney -= betMoney;
        } else if (usrTotDice < comTotDice) {
            System.out.printf("이번판은 컴퓨터가 이겼습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
            usrMoney -= betMoney;
            comMoney += betMoney;
        } else { // 무승부 판정
            System.out.printf("승부가 나지 않았습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
        }
    }   // 아래 입력 값을 받는 매개변수 선언 이렇게 하면 이 매서드를 중복할 필요없이 사용가능
    private void checkSkill (int[] curDice, int[] targetDice) { // 두 번째 주사위는 특수한 기능이 있어서 따로 매서드화
        switch (curDice[SECOND_IDX]) {
            case 1:
                curDice[TOTAL_IDX] = curDice[FIRST_IDX] + 3;
                break;
            case 3:
                targetDice[TOTAL_IDX] = targetDice[FIRST_IDX] - 2;
                break;
            case 4:
                curDice[TOTAL_IDX] = 0;
                break;
            case 6:
                curDice[TOTAL_IDX] = (curDice[FIRST_IDX] + curDice[SECOND_IDX]) * 2;
                targetDice[TOTAL_IDX] = (targetDice[FIRST_IDX] + targetDice[SECOND_IDX]) * 2;
                break;
            default:
                curDice[TOTAL_IDX] = curDice[FIRST_IDX] + curDice[SECOND_IDX];
                break;
        }
    }
    private void checkMagicDiceSkill () {
        // checkSkill 여기서 인자로 usrDice , comDice를 주고 아래는 반대로 해서 관점이 바꿔 재활용을 함
        // 아주 좋은걸 배웠음 내가 쓸 수 있을지는 모르겠음 .. 일단은 복습 ..
        // 사용자 관점에서의 2번째 주사위 스킬 발동
        checkSkill(usrDice, comDice);
        // 컴퓨터 관점에서의 2번째 주사위 스킬 발동
        checkSkill(comDice, usrDice);
    }
                            // 매개변수하나 만듬
    private void runSecondDice (int[] dice) { // 여기는 첫 번째 주사위 값이 짝수이면 두 번째 주사위 값을 다시주는 매서드
        if (dice[FIRST_IDX] % 2 == 0) {     // 매개변수하나 만듬
            dice[SECOND_IDX] = getRandomValue(DICE_RANGE, DICE_START_OFFSET);
        }
    }
    private void runFirstDice (int[] dice) { // 처음 주사위 값 초기화
        dice[FIRST_IDX] = getRandomValue(DICE_RANGE, DICE_START_OFFSET);
    }
    private void runDice () {
        //usrDice[0] = getRandomValue(6, 1);
        //comDice[0] = getRandomValue(6, 1);

        // 첫 번째 주사위를 굴리는 부분
        runFirstDice(usrDice);
        runFirstDice(comDice);

        /*
        if (usrDice[0] % 2 == 0) {
            usrDice[1] = getRandomValue(6, 1);
        }
        if (comDice[0] % 2 == 0) {
            comDice[1] = getRandomValue(6, 1);
        }
         */
        // 두번째 다이스 굴리는 부분 만약 첫 번째 주사위에서 홀수가 나왔다면 실행 x
        runSecondDice(usrDice);
        runSecondDice(comDice);
    }
    public int getRandomValue (int range, int startOffset) { // 주사위값을 가져오기위해 getter로 만들고 매개변수를 둬서
        return (int)(Math.random() * range + startOffset); // 인자를 받게 함 이렇게 해서 위 매서드들이 깔끔해짐
    }
}

public class Prob45Answer {
    public static void main(String[] args) {

        DiceDeathGame ddg = new DiceDeathGame(); // 객체 생성


        ddg.gameStart();  // 객체를 불러 객체 안에 있는 gameStart매서드 호출
    }
}
// 45번 문제를 복습하면서 어느정도 개념과 흐름이 이해는 했는데 이렇게 이해를 했어도 다음 문제가 나오면 멍~ 해집니다 ㅠ
// 하루하루 이해를 하고 넘어가려고 하는데  문제를 풀때는 풀리지가않네요 ㅠ 다른 수강생분들도 그러실수도있고 아니실수도있지만
// 같이 힘내시죠 ..화이팅..
