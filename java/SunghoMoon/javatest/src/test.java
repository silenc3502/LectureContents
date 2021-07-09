
import java.util.Scanner;

public class test {
    public void printNum() {
        Scanner sc = new Scanner(System.in);

        System.out.print("1~10 정수 : ");
        int num = sc.nextInt();

        if(num>=1 || num <=10) {
        for(int i = 1; i <= num; i++) {
        System.out.print(i + " ");
        }
        } else {
        System.out.println("1과 10사이 숫자가 아냐.");
        }
    }
}