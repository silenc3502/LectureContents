import java.util.Scanner;   //정도영씨가 풀은 27번(챌린지문제)

public class hm {
    public static void main(String[] args) {

        int num1=1, num2=0, i=1;

        Scanner sc = new Scanner(System.in);
        System.out.print("n번 째 값 입력 : ");
        int valuN = sc.nextInt();

        while(i<100) {

            if(i==1 || i%2==1) {    //피보나치 수열은 전의 수와 앞의 수가 더해지는 것을 반복하는 것이다
                num1 = num1 + num2;
                //               System.out.println(num);
            } else if(i==2 || i%2==0) {  //
                num2 = num1 + num2;
                //               System.out.println(num2);
            }


            if (i==valuN) {
                if (i==1 || i%2==1) {
                    System.out.print(i + "번 째 값은 : " + num1 + "\n");
                } else System.out.print(i + "번 째 값은 : " + num2 + "\n");
            }
            i++;
        }

    }
}