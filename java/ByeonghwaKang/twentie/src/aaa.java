

import java.util.Scanner;

public class aaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1 ~ 10 사이에 정수를 입력하세요 : ");
        int num = sc.nextInt();

        if (num >= 1 || num <= 10) {
            for (int i = 1; i <= num; i++) {
                System.out.print(i % 2 == 1);
            }
        } else {
                System.out.println("1과 10사이의 숫자가 아닙니다");

            }

        }
    }






