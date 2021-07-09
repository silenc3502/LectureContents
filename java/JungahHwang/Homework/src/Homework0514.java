import java.util.Scanner;

public class Homework0514 {
    public static void main(String[] args) {
// 27.  1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...   (피보나치수열)
// 위의 숫자배치에서 사용자가 n을 입력하면 n번째 값을 구하도록 프로그래밍 해보기


        Scanner scan = new Scanner(System.in);

        int a = 1, b = 0;
        int sum = 1;

        System.out.println("피보나치수열의 n번째가 알고 싶다면 숫자를 입력하세요: ");
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            sum = a + b;
            a = b;
            b = sum; }

        System.out.println(sum);






    }
}