
public class Homework0512 {
    public static void main(String[] args) {
        //15. 1-100까지 숫자중 4의 배수만 출력하기
        for (int i =4; i <=100; i +=4) {
            if (i % 4 ==0)
            { System.out.println(i); }}

        //띄어쓰기 해보기
        for (int i =4; i <=100; i +=4) {
            if (i % 4 ==0)
            { System.out.printf("%4d", i); }}
        System.out.println();


        //16. 1-100까지 숫자중 11의 배수들의 합 구하기
        int sum = 0;
        for(int i =11; i <=100; i +=11){
            sum +=i;
            if(i % 11 ==0) {} }
        System.out.println("1-100까지 11의 배수의 합은 " + sum);


        //17. 컴퓨터와 주사위를 2번 굴려서 더한 숫자가 큰 사람이 이기는 게임
        System.out.println("Me vs Computer");

        int me = 0, com =0; int sum1 =0, sum2 =0;

        for (int i = 1; i <=2 ; i++){
            me = (int) (Math.random() * 6 + 1 );
            System.out.println( me );
            sum1 +=me; }
        System.out.println("내가 던진 주사위의 합: " + sum1 );

        for (int i = 1; i <=2 ; i++){
            com = (int) (Math.random() * 6 + 1 );
            //랜덤하게 나오는 숫자 안보이고 깔끔하게 합만 보고 싶어서 System.out.println( com ); 빼봤어요
            sum2 +=com; }
        System.out.println("컴퓨터가 던진 주사위의 합: " + sum2 );

        System.out.print("결과는?? ");
        if(sum1>sum2){
            System.out.println("Win");}
        else if(sum1<sum2){
            System.out.println("Lose");}
        else {
            System.out.println("Draw"); }


        }




    }

