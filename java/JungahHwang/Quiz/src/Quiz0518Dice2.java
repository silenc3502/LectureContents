// 35. 34번 문제에서 무승부도 표현되게 만들기 --------------------------------------------------

import java.util.Scanner;

class Dice2 {
    int me, com;

    int getRandomDice() {
        return (int) (Math.random() * 6 + 1); }

    Dice2() {
        me = getRandomDice();
        com = getRandomDice(); }

    Scanner scan = new Scanner(System.in);

    int whoWin() {
        if (me > com) {
            return 1; }
        else if (me < com) {
            return 2; }
        else {
            return 3;}
    }

    // 리턴이 없어서 void(Setter도 리턴이 없어서 void)
    void checkWinner() {
        switch (whoWin()) {
            case 1:
                System.out.printf("%d(사용자) vs %d(컴퓨터) 사용자가 이겼습니다.\n", me, com);
                break;
            case 2:
                System.out.printf("%d(사용자) vs %d(컴퓨터) 컴퓨터가 이겼습니다.\n", me, com);
                break;
            case 3:
                System.out.printf("%d(사용자) vs %d(컴퓨터) 무승부입니다.\n", me, com);
                break;
        }
    }

    Boolean reGame() {
        System.out.println("게임을 다시 하시겠습니까? 1(예) / 0(아니오)");
        int num = scan.nextInt();

        Boolean isTrue = false;

        switch (num) {
            case 0:
                isTrue = false;
                break;
            case 1:
                me = getRandomDice();
                com = getRandomDice();
                isTrue = true;
                break;
        }

        return isTrue;

    }
}
public class Quiz0518Dice2 {
    public static void main(String[] args) {
        Dice2 d = new Dice2();

        do { d.checkWinner();}
        while (d.reGame());
        // do-while은 무조건 처음을 실행하고 이후엔 조건에 따라 반복을 할지 정한다.


    }}

