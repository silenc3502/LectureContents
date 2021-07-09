import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("" +
                "1  1 2 3 5 8 ....피나치 배열중 n번쨰 배열의 값을 구해낼것이다. n번쨰구할 값을 입력하시오.");

        int num = scan.nextInt();
        int res = 0;
        //만약 5를 넣었다 치면,
        if(num <= 0)
        {
            System.out.println("입력값은 음수거나 0입니다. 정수로 입력해주세요.");
        }
        else if(num < 3 ){
            System.out.println("당신이 찾는값의 결과는 1입니다.");
        }
        else{
        int first = 1;
        int second = 1;

        // .0   1   1    2   3   5  8    13 .. 피보나치 배열
        // f0 f1  f2   f3  f4  f5  f6   f7..
        // 이 피보나치 배열이 있지만,
        // 내가 5번째, 피보나치배열을 알고싶다고했을때,
        // 내가 입력한, num이 5일때,
        // 이미 아래로직은   num을



         for(int i = 0; i <num -2 ; i++)
         {
             res = first + second;
             first = second;
             second = res;


         }
            System.out.println("결과는 ="+ res);
        }


    }
}
