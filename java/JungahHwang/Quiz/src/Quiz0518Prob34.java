// 34. 주사위문제를 클래스로 풀어보기 -------------------------------------------------------------
class Dice {
    int me, com;

    int getRandomDice() {
        return (int) (Math.random() * 6 + 1); }

    Dice() {
        me = getRandomDice();
        com = getRandomDice(); }

    Boolean whoWin() {
        System.out.printf("사용자 %d vs 컴퓨터 %d\n", me, com);
        if (me > com) {
            return true;
        } else if (me < com) {
            return false;
        } else {
            System.out.println("무승부입니다");
            return false;
        }
        // 무승부 일때도 졌다고 표현함
    }
}
public class Quiz0518Prob34 {
    public static void main(String[] args) {
        Dice d = new Dice();

       if (d.whoWin()) {
            System.out.println("사용자가 승리하였습니다");}
       else {
           System.out.println("컴퓨터가 승리하였습니다");}


        }
    }

