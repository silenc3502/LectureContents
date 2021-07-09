// 1. 나와 상대방 수중에는 1000만원이 있다. 상대방이 파산하면 이긴다.
// 2. 베팅 비율은 Scanner를 통해 입력받을 수 있다.(비율)
// 3. 주사위 2개를 사용하는 게임이다
//    주사위 값의 합이 큰 사람이 이긴다.
// 4. 첫번째 주사위에서 짝수가 나왔을 때만 두번째 주사위를 굴릴 수 있다.
// 5. 두번째 주사위에서 1이 나오면 +3
//                   3이 나오면 상대방 주사위 값 -2
//                   4가 나오면 내 주사위 값이 0
//                   6이 나오면 주사위 값의 합 *2
// 6. 승자와 패자가 있는 게임을 프로그래밍 해보자.

// 게임에서 이겼을때 베팅한 돈은 어떻게 되는건지?
// 컴퓨터의 베팅은?


import java.util.Scanner;

// 한 게이머에게 쓸 코드
class OneGamer{
//    한 게이머의 돈, 주사위, 베팅비율
    String name;
    int wallet;   //수중 금액
    int[] dice;    // 주사위
    int betRate;   //베팅비율

    public OneGamer(String name){
        this.name = name;
        wallet = 1000;
        dice[0] = (int)(Math.random() * 6 + 1);
    }


    public void inputBetRate(int rateScan){
        betRate = 1000 * rateScan;
//        rateScan = 입력값으로 받은 베팅비율
    }

    public void clacDice() {
        for (int i = 0; i < 2; i++) {
            if (dice[0] % 2 != 0) {
                System.out.printf("주사위의 값은 %d입니다. 홀수임으로 주사위를 더 던질 수 없습니다.", dice[0]);
                break;
            } else if (dice[0] % 2 == 0) {
                System.out.printf("주사위 값은 %d입니다. 짝수임으로 주사위를 한번 더 던집니다.", dice[0]);
            }

            System.out.printf("첫번째 주사위 값은 %d, 두번째 주사위 값은 %d입니다.", dice[0], dice[1]);
        }

//        if (dice[1] == 1) {
//            System.out.println("두번째 주사위 값이 1이므로, + 3  = " + (dice[0] + dice[1] + 3));
//        } else if (dice[1] == 4) {
//            System.out.println("두번째 주사위 값이 0이므로, 모든 주사위 값이 0이 되었습니다.");
//        } else if (dice[1] == 6) {
//            System.out.println("두번째 주사위 값이 6이므로, * 2 ! = " + ((dice[0] + dice[1]) * 2));
//        }

//        두번째 주사위 값이 3일때 상대방 주사위 값을 -2 한다는 것을 적을 수 없다.
//        위 계산은 여기서 진행되야 하는것이 아닌 것 같다.

    }

    public int getBetRate() {
        return betRate;
    }

    public int getWallet() {
        return wallet;
    }

    public int[] getDice() {
        return dice;
    }
}

// 두 게이머에게 모두 쓸 코드
public class Quiz45 {

    static final Scanner scan = new Scanner(System.in);

    public static int inputBetRate() {
        System.out.println("베팅 비율을 적어주세요 : ");
        return scan.nextInt();
    }

    public static void calcDiceGame() {
        // 사용자의 베팅 비율 받기
        // 컴퓨터의 주사위 던지기 + 특수 주사위 실행
        // 사용자의 주사위 던지기 + 특수 주사위 실행
        // 승자와 패자
        // wallet이 0이 되는 게이머가 나타날때까지 반복
        ;

    }


//    메인 진행코드
    public static void main(String[] args) {
        String name[] = {"사용자", "컴퓨터"};
        int len = name.length;
        OneGamer[] od = new OneGamer[len];

        for(int i = 0; i < len; i++) {
            od[i] = new OneGamer(name[i]);
        }


        System.out.println("사용자와 컴퓨터의 주사위 게임을 시작합니다.");



    }
}
