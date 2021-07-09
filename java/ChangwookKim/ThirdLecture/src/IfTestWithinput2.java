import java.util.Scanner;

public class IfTestWithinput2 {
    public static void main(String[] args) {

        System.out.println("두 숫자를 입력 받아서 비교해 봅시다.");
        Scanner scan = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력해 주십시오 : ");
        int num1 = scan.nextInt();

        System.out.print("두 번째 숫자를 입력해 주십시오 : ");
        int num2 = scan.nextInt();

        if(num1 > num2) {
            System.out.printf("%d > %d\n", num1, num2);
        } else {
            System.out.printf("%d < %d\n", num1, num2);
        }
    }
}
