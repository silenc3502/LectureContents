import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Calc ddv;
        ddv = new Calcimplement();
        Scanner sc =new Scanner(System.in);

        System.out.println("계산할 방법을 선택하세요");
        System.out.println("1.더하기,2.뺴기");
        int  dd = sc.nextInt();

        switch (dd){

        case 1:
            System.out.println("더하기입니다");
             int num1 = sc.nextInt();
             int num2 = sc.nextInt();
            int fiNaladd =  ddv.add(num1,num2);
            System.out.println(fiNaladd);
            break;
            case 2:
            System.out.println("빼기입니다.");
                int num3 = sc.nextInt();
                int num4 = sc.nextInt();
              int fiNalM =  ddv.Minus(num3,num4);
                System.out.println(fiNalM);
                break;
        }
    }
}
