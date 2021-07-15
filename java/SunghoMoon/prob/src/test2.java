import java.util.Scanner;

public class test2 {
    public void printNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력 : ");
        int num = sc.nextInt();

        if(num >=1 || num <=10) {
            for(int i = 1; i <=num; i++) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("숫자가 아냐");
        }
    }
}