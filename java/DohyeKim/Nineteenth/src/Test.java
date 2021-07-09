import java.util.Scanner;
public class Test {
    public void printNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10사이의 정수를 입력하세여 : ");
        int num = sc.nextInt();

        if(num >= 1 || num <=10) {
            for (int i = 1; i <= num; i++) {
                System.out.print(i + " ");
            }
        }else{
            System.out.println("1과 10 사이의 숫자가 아닙니다.");
        }

    }
}
