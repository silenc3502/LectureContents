import java.util.Scanner;

public class IfTestWithinput {
    public static void main(String[] args) {
        System.out.println("두 개 숫자를 입력 받아 비교해봅니다.");
        Scanner scan = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = scan.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = scan.nextInt();

        if (num1 > num2) {
            System.out.printf("%d > %d\n", num1, num2);
        } else {
            System.out.printf("%d < %d\n", num1, num2);

        }
    }
}
