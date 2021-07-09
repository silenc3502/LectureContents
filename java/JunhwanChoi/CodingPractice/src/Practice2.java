//practice2
//양의 정수 입력받아 약수를 출력하는 프로그램

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        boolean istrue= true;
        int num=0;


        while(istrue)
        {
            int total=0;// while문 돌때마다 total(약수의 총개수) 초기화.

            System.out.printf("양의정수를 입력하세요(종료:0) : ");
            num = sc.nextInt();

            int[] measure= new int[num+1];

            if(num>0)
            {
                //규칙찾기...
                //1의 약수: 1
                //2의 약수: 1,2
                //3의 약수: 1,3
                //4의 약수: 1,2,4        -> num % i == 0   -> i값을 1씩 증가시키면서 나머지가 0이 나오는것 찾기!
                for(int i=1; i<=num; i++)
                {
                    if(num%i==0) //입력된 num를 i로 나누었을때 나머지가 0이 나오면 mesure[]변수에 i값(약수!)를 넣음
                    {
                        total+=1;
                        measure[i]= i;
                        System.out.printf("%d의 약수: %d\n",num,measure[i]);
                    }
                }
                System.out.printf("%d의 약수는 %d개입니다.\n",num,total);
                System.out.println("=====================================");
            }
            else if(num == 0)
            {
                System.out.println("종료하겠습니다.");
                istrue= false;
            }
            else
            {
                System.out.println("다시 입력... 양의 정수만 입력해수세요..");
            }
        }
    }
}
