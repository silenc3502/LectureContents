import java.util.Scanner;

public class Quiz0511 {
        public static void main(String[] args) {

            //3. 숫자 3이 짝수인지 홀수인지 판별하는 코드 만들기

            int num = 3;
            if (num % 2 == 1) { System.out.println("홀수");}
            else { System.out.println("짝수"); }


            //4. 아무 숫자나 3개 입력 받아 그 숫자의 합을 출력하는 코드 만들기

            Scanner scan = new Scanner(System.in);

            System.out.print("첫번째 숫자: ");
            int a = scan.nextInt();
            System.out.print("두번째 숫자: ");
            int b = scan.nextInt();
            System.out.print("세번째 숫자: ");
            int c = scan.nextInt();

            System.out.println("세 숫자의 합 = " + (a + b + c));


            //5. 1-20에서의 숫자 중 2의 배수만 출력하는 코드 만들기

            int j = 2;
            while (j <= 20) { System.out.println(j);
                j += 2; }


            //6. 아무 숫자나 입력 받아 3의 배수인지 판별하기

            System.out.print("아무 숫자나 입력하세요(3의 배수인지 맞추기) :");
            int d = scan.nextInt();
            if (d % 3 == 0) { System.out.println("3의 배수입니다"); }
            else { System.out.println("3의 배수가 아닙니다"); }


            //7. 1부터 입력된 숫자까지에서 3의 배수 판별하기

            System.out.print("1부터 아무 숫자나 입력하세요 :");
            int loop = scan.nextInt();
            int i = 1;
            while (i <= loop) {
                if (i % 3 == 0) { System.out.println("1부터 " + loop + " 까지 3의 배수를 출력합니다: " + i);
                    i++; } }


            //8. 0을 입력하기 전까지 입력하는 값이 짝수인지 홀수인지 지속적으로 판별하기
            int select = 1;
            while (select != 0) {
                System.out.print("짝수인지 홀수인지 판별해보자: ");
                select = scan.nextInt();
                if (select % 2 == 0) { System.out.println(select + " 는 짝수!"); }
                else { System.out.println(select + " 는 홀수!"); }
            }


        }
    }



