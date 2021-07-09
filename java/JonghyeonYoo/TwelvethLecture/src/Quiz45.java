import java.util.Scanner;

//카지노 주사위 게임 (2개를 이용)
// 컴퓨터, 사용자 각자 갖고있는 돈 1000만원
// 비율은 Scanner를 통해 입력 받는다.
// 상대방이 파산하면 이기는 게임
// 주사위 2개를 사용
// 숫자가 높은사람이 이긴다 (컴vs사람)
// 첫번째 주사위가 짝수가 나온 경우만 두번째 주사위를 던질 수 있다.
// 두번째 주사위가 1이 나오면 내 주사위 값에 +3
// 	숫자가 3이 나오면 상대방 주사위 값을 -2
//	숫자가 4가 나오면 내주사위 값은 0
//	숫자가 6이 나오면 각자 주사위 값 2배 증가
//	 (6이 나와 2배증가시 첫번째+두번째 주사위를 모두 진행한 후 적용)
class Casino {
    int comDice;
    int userDice;
    int comMoney = 1000;
    int userMoney = 1000;

    String name;

    public Casino(String name) {
        this.name = name;
        comDice = (int) (Math.random() * 6 + 1);
        userDice = (int) (Math.random() * 6 + 1);
    }

    public void BettingMoney() { // 배팅금액 입력할 메소드
        Scanner scan = new Scanner(System.in);
        System.out.println("배팅금액을 입력하세요 ");
        int BetMoney = scan.nextInt();
        if ((BetMoney < 1000) || (BetMoney < 1)) {
            System.out.print("1~1,000만원 내에서 배팅 하십시오");
        }
    }

    public void RollingDice1() {
        for (int i = 0; i < 2; i++) {
            if (comDice % 2 == 0) {
                switch (comDice) {
                    case 1:
                        comDice = comDice + 3;
                        break;
                    case 2:
                        comDice += comDice;
                        break;
                    case 3:
                        userDice = userDice - 2;
                        break;
                    case 4:
                        comDice = 0;
                        break;
                    case 5:
                        comDice += comDice;
                        break;
                    case 6:
                        comDice = comDice * 2;
                        userDice = userDice * 2;
                        break;
                }
            }
        }
    }
        public void RollingDice2 () {
            for (int i = 0; i < 2; i++) {
                if (userDice % 2 == 0) {
                    switch (userDice) {
                        case 1:
                            userDice = userDice + 3;
                            break;
                        case 2:
                            userDice += userDice;
                            break;
                        case 3:
                            comDice = comDice - 2;
                            break;
                        case 4:
                            userDice = 0;
                            break;
                        case 5:
                            userDice += userDice;
                            break;
                        case 6:
                            comDice = comDice * 2;
                            userDice = userDice * 2;
                            break;
                    }
                }
            }
        }
    public int getComDice() {
        return comDice;
    }

    public int getUserDice() {
        return userDice;
    }

}


    public class Quiz45 {
        public static void main(String[] args) {
            String[] gamerArr = {"사용자", "컴퓨터"};
            int gamerLen = gamerArr.length;
            Casino[] cs = new Casino[gamerLen];

            for (int i = 0; i < gamerLen; i++) {

                cs[i].RollingDice1();

            }
        }
    }




