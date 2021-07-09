// practice 1
// 홀짝구분

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);

        System.out.printf("숫자를 입력하세요:");
        int num= scan.nextInt();


        if(num%2==1)
        {
            System.out.println("입력하신 숫자는: "+ num +", 홀수입니다.");
        }
        else if(num%2==0)
        {
            System.out.println("입력하신 숫자는: "+ num +", 짝수입니다.");

        }


    }
}
