//컴퓨터와 주사위 게임을 해보자!
//주사위를 2번 굴려서 합산 눈금 숫자가 큰 사람이 이기는 것으로 한다.
// 각 주사위 값을 보여주자
//배열써서 해결하자

public class DiceGame {
    public static void main(String[] args) {

        int comDice1 = (int)(Math.random() * 6 + 1);
        int comDice2 = (int)(Math.random() * 6 + 1);

        int comDice= comDice1 + comDice2;

        int userDice1 = (int)(Math.random() * 6 + 1);
        int userDice2 = (int)(Math.random() * 6 + 1);

        int userDice = userDice1 + userDice2;

        System.out.printf("컴퓨터 주사위의 합은 %d\n", comDice);
        System.out.printf("사용자 주사위의 합은 %d\n", userDice);


        if(comDice > userDice){
            System.out.println("컴퓨터 승!");
        } else if(comDice < userDice){
            System.out.println("사람 승!");
        }else{
            System.out.println("무승부!");
        }
    }


}
