// 카지노 주사위 게임
// 1000원으로 베팅 비율은 Scanner 이용
// 주사위 2개를 사용 숫자가 높은 사람이 이긴다(컴퓨터 vs 사람)
// 첫 번째 주사위가 짝수가 나온 경우에만 두 번째 주사위를 굴릴 수 있다.
// 두 번째 주사위 조건
// 숫자 1이 나오면 내 주사위 값을 + 3 할 수 있다.
// 숫자가 3이 나오면 상대방 주사위 값을 -2 할 수 있다.
// 숫자 4가 나오면 내 주사위 값이 0이 된다.
// 숫자 6이 나오면 각자 만든 주사위 값을 2배 (첫번째 주사위 + 두번째 주사위)
// 파산하면 지는 게임

import java.util.Scanner;

class Dice{
    String who;
    int firstDice;
    int secondDice;
    int sumDice;

    public Dice(String who){
        this.who = who;

        firstDice = (int)(Math.random() * 6 + 1);
        secondDice = (int)(Math.random() * 6 + 1);
    }

    public void first() {
        if (firstDice % 2 == 0) {
            System.out.printf("첫번째 주사위 %d로 두번째 주사위를 굴립니다.\n", firstDice);
            second();
        } else { sumDice = firstDice;
            System.out.printf("첫번째 주사위 %d로 두번쨰 주사위는 굴리지 않습니다.\n", firstDice);
        }
    }

    public void second(){
        if (secondDice == 1){
            sumDice = firstDice + 3;
            System.out.printf("두번째 주사위 1로 %d에 +3하여 합계 %d입니다.\n", firstDice, sumDice);
        }else if(secondDice == 3){
            sumDice = firstDice - 2;
            System.out.printf("두번째 주사위 3으로 %d에 -2하여 합계 %d입니다.\n", firstDice, sumDice);
            // 상대방 주사위를 -2 하는 방법은 모르겠어서 그냥 내 주사위 -2 했어요 ㅠㅠ
        }else if(secondDice == 4){
            sumDice = 0;
            System.out.printf("두번째 주사위 4로 %d이 %d이 됩니다.\n", firstDice, sumDice);
        }else if(secondDice == 6){
            sumDice = (firstDice + secondDice) * 2;
            System.out.printf("두번째 주사위 6으로 %d에 6을 더하고 2를 곱하여 %d입니다.\n", firstDice, sumDice);
        }else{
            sumDice = firstDice + secondDice;
            System.out.printf("첫번째 주사위 %d와 두번재 주사위 %d를 더하여 합계 %d입니다.\n", firstDice, secondDice, sumDice);
        }
    }

    public int getSumDice() { return sumDice; }
}

class Player {
    final String who[] = {"ME", "YOU"};
    Dice d[] = new Dice[who.length];

    int meMoney = 1000, youMoney = 1000;
    int num;
    Scanner scan;

    public void betting(){
        scan = new Scanner(System.in);
        System.out.println();
        System.out.print("얼마를 베팅하시겠습니까?? ");
        num = scan.nextInt();

        if ((meMoney < num)||(youMoney < num)){
            System.out.printf("잔액이 부족합니다.\n");
            betting();
        }
    }
    public void startDice(){
        for(int i = 0; i < who.length; i++){
            d[i] = new Dice(who[i]);

            System.out.println();
            System.out.printf("%s가 주사위를 굴립니다.\n", who[i]);

            d[i].first(); }
    }
    public void resultDice(){
        System.out.println();
        if (d[0].getSumDice() > d[1].getSumDice()){
            System.out.printf("%s: %d vs %s: %d로 내가 승리하였습니다.\n",
                    who[0], d[0].getSumDice(),who[1], d[1].getSumDice());
            meMoney += num;
            youMoney -= num;
            System.out.printf("%s의 잔액은 %d원, %s의 잔액은 %d원 입니다.\n",who[0], meMoney, who[1], youMoney);
        }else if(d[0].getSumDice() < d[1].getSumDice()){
            System.out.printf("%s: %d vs %s: %d로 상대방이 승리하였습니다.\n",
                    who[0], d[0].getSumDice(),who[1], d[1].getSumDice());
            meMoney -= num;
            youMoney += num;
            System.out.printf("%s의 잔액은 %d원, %s의 잔액은 %d원 입니다.\n",who[0], meMoney, who[1], youMoney);
        }else if(d[0].getSumDice() == d[1].getSumDice()){
            System.out.printf("%s: %d vs %s: %d로 무승부입니다. 게임을 다시시작합니다.\n",
                    who[0], d[0].getSumDice(),who[1], d[1].getSumDice());}
    }
    public void endDice(){
        System.out.println();
        if(meMoney == 0){
            System.out.printf("%s가 파산하였습니다.", who[0]);
        }else if(youMoney == 0){
            System.out.printf("%s가 파산하였습니다.", who[1]);
        }
    }

    public int getMeMoney() { return meMoney; }
    public int getYouMoney() { return youMoney; }
    public int getNum() { return num; }
}

public class Homework0525Prob45 {
    public static void main(String[] args) {
        Player p = new Player();


        while (!(p.getMeMoney() == 0)&&!(p.getYouMoney() == 0)){
            p.betting();
            p.startDice();
            p.resultDice();
        }

        p.endDice();







    }
}
